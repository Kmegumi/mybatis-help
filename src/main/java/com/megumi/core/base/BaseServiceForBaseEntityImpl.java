package com.megumi.core.base;

import com.megumi.core.exception.DAOException;
import com.megumi.core.exception.LockException;
import com.megumi.core.utils.BaseServiceUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

/**
 * 实现BaseService类
 * @author megumi
 * @date 2018/06/06.
 */
@Slf4j
public class BaseServiceForBaseEntityImpl<Mapper, Record extends BaseEntity, Example extends BaseExample> extends BaseServiceImpl<Mapper, Record, Example> implements BaseServiceForBaseEntity<Record, Example> {

	/**
	 * 插入记录
	 *
	 * @param record
	 * @return
	 */
	@Override
	public int insert(Record record) {
		BaseServiceUtils.initInsert(record);
		return super.insert(record);
	}

	/**
	 * 插入记录
	 *
	 * @param record
	 * @return
	 */
	@Override
	public boolean insertWithCatch(Record record) {
		BaseServiceUtils.initInsert(record);
		return super.insertWithCatch(record);
	}

	/**
	 * 插入记录
	 *
	 * @param record
	 * @return
	 */
	@Override
	public int insertSelective(Record record) {
		BaseServiceUtils.initInsert(record);
		return super.insertSelective(record);
	}

	/**
	 * 插入记录
	 *
	 * @param record
	 * @return
	 */
	@Override
	public boolean insertSelectiveWithCatch(Record record) {
		BaseServiceUtils.initInsert(record);
		return super.insertSelectiveWithCatch(record);
	}


	/**
	 * 根据条件更新有效字段
	 *
	 * @param record
	 * @param example
	 * @return
	 */
	@Override
	public int updateByExampleSelective(Record record, Example example) {
		Assert.notNull(example, "条件对象为空");
		BaseServiceUtils.initUpdate(record);
		return super.updateByExampleSelective(record, example);
	}

	/**
	 * 根据条件更新记录
	 *
	 * @param record
	 * @param example
	 * @return
	 */
	@Override
	public int updateByExample(Record record, Example example) {
		Assert.notNull(example, "条件对象为空");
		BaseServiceUtils.initUpdate(record);
		return super.updateByExample(record, example);
	}


	/**
	 * 根据主键更新记录有效字段
	 *
	 * @param record
	 * @return
	 */
	@Override
	public int updateByPrimaryKeySelective(Record record) {
		BaseServiceUtils.initUpdate(record);
		return super.updateByPrimaryKeySelective(record);
	}

	/**
	 * 根据主键更新记录
	 *
	 * @param record
	 * @return
	 */
	@Override
	public int updateByPrimaryKey(Record record) {
		BaseServiceUtils.initUpdate(record);
		return super.updateByPrimaryKey(record);
	}


	/**
	 * 根据主键更新记录有效字段
	 *
	 * @param record
	 * @return
	 */
	@Override
	public boolean updateByPrimaryKeySelectiveWithCatch(Record record) {
		BaseServiceUtils.initUpdate(record);
		return super.updateByPrimaryKeySelectiveWithCatch(record);
	}

	/**
	 * 根据主键更新记录
	 *
	 * @param record
	 * @return
	 */
	@Override
	public boolean updateByPrimaryKeyWithCatch(Record record) {
		BaseServiceUtils.initUpdate(record);
		return super.updateByPrimaryKeyWithCatch(record);
	}


	/**
	 * 根据版本号修改对象
	 *
	 * @param record
	 * @param exampleClass
	 * @return
	 */
	@Override
	public boolean updateByPrimaryKeyAndVersion(Record record, Class<Example> exampleClass) {
		Assert.notNull(record, "对象为空");
		if (record.getId() == null) {
			throw new DAOException("缺少id");
		}
		if (record.getVersion() == null) {
			throw new DAOException("缺少版本信息");
		}
		record.setLastUpdateDatetime(LocalDateTime.now());
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
		int result;
		try {
			result = (int)mapper.getClass()
					.getDeclaredMethod("updateByExampleSelective", record.getClass(), example.getClass())
					.invoke(mapper, record, example);
		} catch (Exception e){
			log.error(record.toString() + "_" + e.getMessage(), e);
			return false;
		}
		if (result == 0) {
			throw new LockException("version or id err");
		}
		return true;
	}
}