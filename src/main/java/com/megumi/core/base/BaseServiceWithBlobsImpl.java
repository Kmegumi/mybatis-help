package com.megumi.core.base;


import com.megumi.core.exception.DAOException;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.util.List;

/**
 * BaseService接口
 * @author megumi
 * @date 2018/06/06.
 */
public class BaseServiceWithBlobsImpl<Mapper, Record extends BaseEntity, RecordWithBlobs extends Record, Example extends BaseExample> implements BaseServiceWithBlobs<Record, RecordWithBlobs, Example> {

    @Autowired
    protected Mapper mapper;

    /**
     * 根据条件查询记录数量
     *
     * @param example
     * @return
     */
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

    /**
     * 根据条件删除记录
     *
     * @param example
     * @return
     */
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

    /**
     * 根据主键删除记录
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        try {
            Method deleteByPrimaryKey = mapper.getClass().getDeclaredMethod("deleteByPrimaryKey", id.getClass());
            Object result = deleteByPrimaryKey.invoke(mapper, id);
            return (int)result;
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    /**
     * 插入记录
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public int insert(RecordWithBlobs recordWithBlobs) {
        try {
            Method insert = mapper.getClass().getDeclaredMethod("insert", recordWithBlobs.getClass());
            Object result = insert.invoke(mapper, recordWithBlobs);
            return (int)result;
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    /**
     * 插入记录有效字段
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public int insertSelective(RecordWithBlobs recordWithBlobs) {
        try {
            Method insertSelective = mapper.getClass().getDeclaredMethod("insertSelective", recordWithBlobs.getClass());
            Object result = insertSelective.invoke(mapper, recordWithBlobs);
            return (int)result;
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    /**
     * 根据条件查询记录，附带BLOB字段
     *
     * @param example
     * @return
     */
    @Override
    public List<RecordWithBlobs> selectByExampleWithBLOBs(Example example) {
        try {
            Method selectByExampleWithBLOBs = mapper.getClass().getDeclaredMethod("selectByExampleWithBLOBs", example.getClass());
            Object result = selectByExampleWithBLOBs.invoke(mapper, example);
            return (List<RecordWithBlobs>) result;
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    /**
     * 根据条件查询第一条记录，附带BLOB字段
     *
     * @param example
     * @return
     */
    @Override
    public RecordWithBlobs selectFirstByExampleWithBLOBs(Example example) {
        try {
            Method selectByExampleWithBLOBs = mapper.getClass().getDeclaredMethod("selectByExampleWithBLOBs", example.getClass());
            List<RecordWithBlobs> result = (List<RecordWithBlobs>) selectByExampleWithBLOBs.invoke(mapper, example);
            if (null != result && result.size() > 0) {
                return result.get(0);
            }
            return null;
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    /**
     * 根据条件查询记录
     *
     * @param example
     * @return
     */
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

    /**
     * 根据条件查询第一条记录
     *
     * @param example
     * @return
     */
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

    /**
     * 根据主键查询记录
     *
     * @param id
     * @return
     */
    @Override
    public RecordWithBlobs selectByPrimaryKey(Long id) {
        try {
            Method selectByPrimaryKey = mapper.getClass().getDeclaredMethod("selectByPrimaryKey", id.getClass());
            Object result = selectByPrimaryKey.invoke(mapper, id);
            return (RecordWithBlobs) result;
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    /**
     * @param recordWithBlobs
     * @param exampleClass
     */
    @Override
    public int updateByPrimaryKeyAndVersion(RecordWithBlobs recordWithBlobs, Class<Example> exampleClass) {
        Example example = null;
        try {
            example = exampleClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new DAOException("实例化查询对象失败",  e);
        }
        BaseGeneratedCriteria baseGeneratedCriteria = example.createCriteria();
        baseGeneratedCriteria.andIdEqualTo(recordWithBlobs.getId());
        baseGeneratedCriteria.andVersionEqualTo(recordWithBlobs.getVersion());
        return updateByExampleSelective(recordWithBlobs, example);
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
        try {
            Method updateByExampleSelective = mapper.getClass().getDeclaredMethod("updateByExampleSelective", recordWithBlobs.getClass(), example.getClass());
            Object result = updateByExampleSelective.invoke(mapper, recordWithBlobs, example);
            return (int)result;
        } catch (Exception e) {
            throw new DAOException(e);
        }
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
        try {
            Method updateByExampleWithBLOBs = mapper.getClass().getDeclaredMethod("updateByExampleWithBLOBs", recordWithBlobs.getClass(), example.getClass());
            Object result = updateByExampleWithBLOBs.invoke(mapper, recordWithBlobs, example);
            return (int)result;
        } catch (Exception e) {
            throw new DAOException(e);
        }
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
        try {
            Method updateByExample = mapper.getClass().getDeclaredMethod("updateByExample", record.getClass(), example.getClass());
            Object result = updateByExample.invoke(mapper, record, example);
            return (int)result;
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    /**
     * 根据主键更新记录有效字段
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(RecordWithBlobs recordWithBlobs) {
        try {
            Method updateByPrimaryKeySelective = mapper.getClass().getDeclaredMethod("updateByPrimaryKeySelective", recordWithBlobs.getClass());
            Object result = updateByPrimaryKeySelective.invoke(mapper, recordWithBlobs);
            return (int)result;
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    /**
     * 根据主键更新记录，附带BLOB字段
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public int updateByPrimaryKeyWithBLOBs(RecordWithBlobs recordWithBlobs) {
        try {
            Method updateByPrimaryKeyWithBLOBs = mapper.getClass().getDeclaredMethod("updateByPrimaryKeyWithBLOBs", recordWithBlobs.getClass());
            Object result = updateByPrimaryKeyWithBLOBs.invoke(mapper, recordWithBlobs);
            return (int)result;
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    /**
     * 根据主键更新记录
     *
     * @param record
     * @return
     */
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