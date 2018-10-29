package com.megumi.core.base;

import com.megumi.core.exception.DAOException;
import com.megumi.core.exception.LockException;
import com.megumi.core.utils.BaseServiceUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

/**
 * BaseService接口
 * @author megumi
 * @date 2018/06/06.
 */
@Slf4j
public class BaseServiceForBaseEntityWithBLOBsImpl<Mapper, Record extends BaseEntity, RecordWithBlobs extends Record, Example extends BaseExample> extends BaseServiceWithBLOBsImpl<Mapper, Record, RecordWithBlobs, Example> implements BaseServiceForBaseEntityWithBLOBs<Record, RecordWithBlobs, Example> {


    /**
     * 根据版本号修改对象
     *
     * @param recordWithBlobs
     * @param exampleClass
     */
    @Override
    public boolean updateByPrimaryKeyAndVersion(RecordWithBlobs recordWithBlobs, Class<Example> exampleClass) {
        Assert.notNull(recordWithBlobs, "对象为空");
        if (recordWithBlobs.getId() == null) {
            throw new DAOException("缺少id");
        }
        if (recordWithBlobs.getVersion() == null) {
            throw new DAOException("缺少版本信息");
        }
        recordWithBlobs.setLastUpdateDatetime(LocalDateTime.now());
        Example example = null;
        try {
            example = exampleClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new DAOException("实例化查询对象失败",  e);
        }
        BaseGeneratedCriteria baseGeneratedCriteria = example.createCriteria();
        baseGeneratedCriteria.andIdEqualTo(recordWithBlobs.getId());
        baseGeneratedCriteria.andVersionEqualTo(recordWithBlobs.getVersion());
        recordWithBlobs.setVersion(recordWithBlobs.getVersion()+1);
        int result;
        try {
            result = (int)mapper.getClass()
                    .getDeclaredMethod("updateByExampleSelective", recordWithBlobs.getClass(), example.getClass())
                    .invoke(mapper, recordWithBlobs, example);
        } catch (Exception e){
            log.error(recordWithBlobs.toString() + "_" + e.getMessage(), e);
            throw new DAOException(e);
        }
        if (result == 0) {
            throw new LockException("version or id err");
        }
        return true;
    }

    /**
     * 根据版本号修改对象
     *
     * @param recordWithBlobs
     * @param exampleClass
     */
    @Override
    public boolean updateByPrimaryKeyAndVersionWithCatch(RecordWithBlobs recordWithBlobs, Class<Example> exampleClass) {
        Assert.notNull(recordWithBlobs, "对象为空");
        if (recordWithBlobs.getId() == null) {
            log.error(recordWithBlobs.getClass().getName() + "_缺少id");
            return false;
        }
        if (recordWithBlobs.getVersion() == null) {
            log.error(recordWithBlobs.getClass().getName() + "_缺少版本信息");
            return false;
        }
        recordWithBlobs.setLastUpdateDatetime(LocalDateTime.now());
        Example example = null;
        try {
            example = exampleClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("实例化查询对象失败_" + e.getMessage(), e);
            return false;
        }
        BaseGeneratedCriteria baseGeneratedCriteria = example.createCriteria();
        baseGeneratedCriteria.andIdEqualTo(recordWithBlobs.getId());
        baseGeneratedCriteria.andVersionEqualTo(recordWithBlobs.getVersion());
        recordWithBlobs.setVersion(recordWithBlobs.getVersion()+1);
        int result;
        try {
            result = (int)mapper.getClass()
                    .getDeclaredMethod("updateByExampleSelective", recordWithBlobs.getClass(), example.getClass())
                    .invoke(mapper, recordWithBlobs, example);
        } catch (Exception e){
            log.error(recordWithBlobs.toString() + "_" + e.getMessage(), e);
            return false;
        }
        if (result == 0) {
            throw new LockException("version or id err");
        }
        return true;
    }

    /**
     * 插入记录
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public int insert(RecordWithBlobs recordWithBlobs) {
        BaseServiceUtils.initInsert(recordWithBlobs);
        return super.insert(recordWithBlobs);
    }

    /**
     * 插入记录有效字段
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public int insertSelective(RecordWithBlobs recordWithBlobs) {
        BaseServiceUtils.initInsert(recordWithBlobs);
        return super.insert(recordWithBlobs);
    }

    /**
     * 根据条件更新有效字段
     *
     * @param recordWithBlobs
     * @param example
     * @return
     */
    @Override
    public int updateByExampleSelective(RecordWithBlobs recordWithBlobs, Example example) {
        Assert.notNull(example, "条件对象为空");
        BaseServiceUtils.initUpdate(recordWithBlobs);
        return super.updateByExampleSelective(recordWithBlobs, example);
    }

    /**
     * 根据条件更新记录有效字段，附带BLOB字段
     *
     * @param recordWithBlobs
     * @param example
     * @return
     */
    @Override
    public int updateByExampleWithBLOBs(RecordWithBlobs recordWithBlobs, Example example) {
        Assert.notNull(example, "条件对象为空");
        BaseServiceUtils.initUpdate(recordWithBlobs);
        return super.updateByExampleWithBLOBs(recordWithBlobs, example);
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
     * @param recordWithBlobs
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(RecordWithBlobs recordWithBlobs) {
        Assert.notNull(recordWithBlobs, "条件对象为空");
        BaseServiceUtils.initUpdate(recordWithBlobs);
        return super.updateByPrimaryKeySelective(recordWithBlobs);
    }

    /**
     * 根据主键更新记录，附带BLOB字段
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public int updateByPrimaryKeyWithBLOBs(RecordWithBlobs recordWithBlobs) {
        Assert.notNull(recordWithBlobs, "条件对象为空");
        BaseServiceUtils.initUpdate(recordWithBlobs);
        return super.updateByPrimaryKeyWithBLOBs(recordWithBlobs);
    }

    /**
     * 根据主键更新记录
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(Record record) {
        Assert.notNull(record, "条件对象为空");
        BaseServiceUtils.initUpdate(record);
        return super.updateByPrimaryKey(record);
    }


    /**
     * 插入记录
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public boolean insertWithCatch(RecordWithBlobs recordWithBlobs) {
        BaseServiceUtils.initInsert(recordWithBlobs);
        return super.insertWithCatch(recordWithBlobs);
    }

    /**
     * 插入记录有效字段
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public boolean insertSelectiveWithCatch(RecordWithBlobs recordWithBlobs) {
        BaseServiceUtils.initInsert(recordWithBlobs);
        return super.insertSelectiveWithCatch(recordWithBlobs);
    }


    /**
     * 根据主键更新记录有效字段
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public boolean updateByPrimaryKeySelectiveWithCatch(RecordWithBlobs recordWithBlobs) {
        Assert.notNull(recordWithBlobs, "条件对象为空");
        BaseServiceUtils.initUpdate(recordWithBlobs);
        return super.updateByPrimaryKeySelectiveWithCatch(recordWithBlobs);
    }

    /**
     * 根据主键更新记录，附带BLOB字段
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public boolean updateByPrimaryKeyWithBLOBsWithCatch(RecordWithBlobs recordWithBlobs) {
        Assert.notNull(recordWithBlobs, "条件对象为空");
        BaseServiceUtils.initUpdate(recordWithBlobs);
        return super.updateByPrimaryKeyWithBLOBsWithCatch(recordWithBlobs);
    }

    /**
     * 根据主键更新记录
     *
     * @param record
     * @return
     */
    @Override
    public boolean updateByPrimaryKeyWithCatch(Record record) {
        Assert.notNull(record, "条件对象为空");
        BaseServiceUtils.initUpdate(record);
        return super.updateByPrimaryKeyWithCatch(record);
    }
}