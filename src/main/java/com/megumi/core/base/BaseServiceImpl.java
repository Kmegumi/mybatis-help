package com.megumi.core.base;

import com.megumi.core.exception.DAOException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 实现BaseService类
 * @author megumi
 * @date 2018/06/06.
 */
public class BaseServiceImpl<Mapper, Record extends BaseEntity, Example extends BaseExample> implements BaseService<Record, Example> {

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
		try {
			Method insert = mapper.getClass().getDeclaredMethod("insert", record.getClass());
			Object result = insert.invoke(mapper, record);
			return (int)result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public int insertSelective(Record record) {
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

	@Override
	public int updateByPrimaryKeyAndVersion(Record record, Class<Example> exampleClass) {
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
		return updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example) {
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
		try {
			Method updateByPrimaryKey = mapper.getClass().getDeclaredMethod("updateByPrimaryKey", record.getClass());
			Object result = updateByPrimaryKey.invoke(mapper, record);
			return (int)result;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}