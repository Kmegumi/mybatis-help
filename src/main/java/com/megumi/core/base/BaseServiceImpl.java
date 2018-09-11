package com.megumi.core.base;

import com.megumi.core.exception.DAOException;
import com.megumi.core.exception.LockException;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * 实现BaseService类
 * @author megumi
 * @date 2018/06/06.
 */
public class BaseServiceImpl<Mapper, Record extends BaseEntity, Example extends BaseExample> implements BaseService<Record, Example> {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected Mapper mapper;

	@Override
	public long countByExample(Example example) {
		try {
			Method countByExample = mapper.getClass().getDeclaredMethod("countByExample", example.getClass());
			Object result = countByExample.invoke(mapper, example);
			return (long)result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public int deleteByExample(Example example) {
		try {
			Method deleteByExample = mapper.getClass().getDeclaredMethod("deleteByExample", example.getClass());
			Object result = deleteByExample.invoke(mapper, example);
			return (int)result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		try {
			Method deleteByPrimaryKey = mapper.getClass().getDeclaredMethod("deleteByPrimaryKey", id.getClass());
			Object result = deleteByPrimaryKey.invoke(mapper, id);
			return (int)result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public int insert(Record record) {
		record.setId(null);
		record.setVersion(0);
		Date now = new Date();
		record.setCreateDatetime(now);
		record.setLastUpdateDatetime(now);
		try {
			Method insert = mapper.getClass().getDeclaredMethod("insert", record.getClass());
			Object result = insert.invoke(mapper, record);
			return (int)result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	/**
	 * 插入记录
	 *
	 * @param record
	 * @return
	 */
	@Override
	public boolean insertWithCatch(Record record) {
		record.setId(null);
		record.setVersion(0);
		Date now = new Date();
		record.setCreateDatetime(now);
		record.setLastUpdateDatetime(now);
		try {
			Method insert = mapper.getClass().getDeclaredMethod("insert", record.getClass());
			if ((int)insert.invoke(mapper, record) == 1) {
				return true;
			}
		} catch (Exception e) {
			logger.error(record.toString() + "_" + e.getMessage(), e);
		}
		return false;
	}

	@Override
	public int insertSelective(Record record) {
		record.setId(null);
		record.setVersion(0);
		Date now = new Date();
		record.setCreateDatetime(now);
		record.setLastUpdateDatetime(now);
		try {
			Method insertSelective = mapper.getClass().getDeclaredMethod("insertSelective", record.getClass());
			Object result = insertSelective.invoke(mapper, record);
			return (int)result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<Record> selectByExampleWithBLOBs(Example example) {
		try {
			Method selectByExampleWithBLOBs = mapper.getClass().getDeclaredMethod("selectByExampleWithBLOBs", example.getClass());
			Object result = selectByExampleWithBLOBs.invoke(mapper, example);
			return (List<Record>) result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<Record> selectByExample(Example example) {
		try {
			Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample", example.getClass());
			Object result = selectByExample.invoke(mapper, example);
			return (List<Record>) result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public Record selectFirstByExample(Example example) {
		try {
			Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample", example.getClass());
			List<Record> result = (List<Record>) selectByExample.invoke(mapper, example);
			if (null != result && result.size() > 0) {
				return result.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public Record selectFirstByExampleWithBLOBs(Example example) {
		try {
			Method selectByExampleWithBLOBs = mapper.getClass().getDeclaredMethod("selectByExampleWithBLOBs", example.getClass());
			List<Record> result = (List<Record>) selectByExampleWithBLOBs.invoke(mapper, example);
			if (null != result && result.size() > 0) {
				return result.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public Record selectByPrimaryKey(Integer id) {
		try {
			Method selectByPrimaryKey = mapper.getClass().getDeclaredMethod("selectByPrimaryKey", id.getClass());
			Object result = selectByPrimaryKey.invoke(mapper, id);
			return (Record) result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	/**
	 * 根据主键查询记录
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Record selectByPrimaryKeyWithCatch(Integer id) {
		try {
			Method selectByPrimaryKey = mapper.getClass().getDeclaredMethod("selectByPrimaryKey", id.getClass());
			Object result = selectByPrimaryKey.invoke(mapper, id);
			return (Record) result;
		} catch (Exception e) {
			logger.error("id_"+ id+"_"+e.getMessage(), e);
		}
		return null;
	}

	@Override
	public int updateByPrimaryKeyAndVersion(Record record, Class<Example> exampleClass) {
		if (record.getId() == null) {
			throw new DAOException("缺少id");
		}
		if (record.getVersion() == null) {
			throw new DAOException("缺少版本信息");
		}
		record.setLastUpdateDatetime(new Date());
		Example example = null;
		try {
			example = exampleClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new DAOException("实例化查询对象失败",  e);
		}
		BaseGeneratedCriteria baseGeneratedCriteria = example.createCriteria();
		baseGeneratedCriteria.andIdEqualTo(record.getId());
		baseGeneratedCriteria.andVersionEqualTo(record.getVersion());
		record.setVersion(record.getVersion()+1);
		int result = updateByExampleSelective(record, example);
		if (result == 0) {
			throw new LockException("version or id err");
		}
		return result;
	}

	@Override
	public int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example) {
		record.setLastUpdateDatetime(new Date());
		try {
			Method updateByExampleSelective = mapper.getClass().getDeclaredMethod("updateByExampleSelective", record.getClass(), example.getClass());
			Object result = updateByExampleSelective.invoke(mapper, record, example);
			return (int)result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") Example example) {
		record.setLastUpdateDatetime(new Date());
		try {
			Method updateByExampleWithBLOBs = mapper.getClass().getDeclaredMethod("updateByExampleWithBLOBs", record.getClass(), example.getClass());
			Object result = updateByExampleWithBLOBs.invoke(mapper, record, example);
			return (int)result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public int updateByExample(@Param("record") Record record, @Param("example") Example example) {
		record.setLastUpdateDatetime(new Date());
		try {
			Method updateByExample = mapper.getClass().getDeclaredMethod("updateByExample", record.getClass(), example.getClass());
			Object result = updateByExample.invoke(mapper, record, example);
			return (int)result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public int updateByPrimaryKeySelective(Record record) {
		if (record.getId() == null) {
			throw new DAOException("缺少id");
		}
		record.setLastUpdateDatetime(new Date());
		try {
			Method updateByPrimaryKeySelective = mapper.getClass().getDeclaredMethod("updateByPrimaryKeySelective", record.getClass());
			Object result = updateByPrimaryKeySelective.invoke(mapper, record);
			return (int)result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Record record) {
		if (record.getId() == null) {
			throw new DAOException("缺少id");
		}
		record.setLastUpdateDatetime(new Date());
		try {
			Method updateByPrimaryKeyWithBLOBs = mapper.getClass().getDeclaredMethod("updateByPrimaryKeyWithBLOBs", record.getClass());
			Object result = updateByPrimaryKeyWithBLOBs.invoke(mapper, record);
			return (int)result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public int updateByPrimaryKey(Record record) {
		if (record.getId() == null) {
			throw new DAOException("缺少id");
		}
		record.setLastUpdateDatetime(new Date());
		try {
			Method updateByPrimaryKey = mapper.getClass().getDeclaredMethod("updateByPrimaryKey", record.getClass());
			Object result = updateByPrimaryKey.invoke(mapper, record);
			return (int)result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}