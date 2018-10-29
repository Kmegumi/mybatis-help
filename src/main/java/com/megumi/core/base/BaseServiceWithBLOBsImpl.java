package com.megumi.core.base;


import com.megumi.core.exception.DAOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * BaseService接口
 * @author megumi
 * @date 2018/06/06.
 */
@Slf4j
public class BaseServiceWithBLOBsImpl<Mapper, Record, RecordWithBlobs extends Record, Example> implements BaseServiceWithBLOBs<Record, RecordWithBlobs, Example> {


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
        Assert.notNull(example, "条件对象为空");
        try {
            return (long) mapper.getClass()
                    .getDeclaredMethod("countByExample", example.getClass())
                    .invoke(mapper, example);
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
        Assert.notNull(example, "条件对象为空");
        try {
            return (int)mapper.getClass()
                    .getDeclaredMethod("deleteByExample", example.getClass())
                    .invoke(mapper, example);
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
    public int deleteByPrimaryKey(Integer id) {
        Assert.notNull(id, "条件对象为空");
        try {
            return (int)mapper.getClass()
                    .getDeclaredMethod("deleteByPrimaryKey", id.getClass())
                    .invoke(mapper, id);
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
        Assert.notNull(recordWithBlobs, "对象为空");
        try {
            return (int)mapper.getClass()
                    .getDeclaredMethod("insert", recordWithBlobs.getClass())
                    .invoke(mapper, recordWithBlobs);
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
        Assert.notNull(recordWithBlobs, "对象为空");
        try {
            return (int)mapper.getClass()
                    .getDeclaredMethod("insertSelective", recordWithBlobs.getClass())
                    .invoke(mapper, recordWithBlobs);
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
    @SuppressWarnings("unchecked")
    public List<RecordWithBlobs> selectByExampleWithBLOBs(Example example) {
        Assert.notNull(example, "条件对象为空");
        try {
            return (List<RecordWithBlobs>)mapper.getClass()
                    .getDeclaredMethod("selectByExampleWithBLOBs", example.getClass())
                    .invoke(mapper, example);
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
    @SuppressWarnings("unchecked")
    public List<Record> selectByExample(Example example) {
        Assert.notNull(example, "条件对象为空");
        try {
            return (List<Record>)mapper.getClass()
                    .getDeclaredMethod("selectByExample", example.getClass())
                    .invoke(mapper, example);
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
    @SuppressWarnings("unchecked")
    public RecordWithBlobs selectByPrimaryKey(Integer id) {
        Assert.notNull(id, "条件对象为空");
        try {
            return (RecordWithBlobs)mapper.getClass()
                    .getDeclaredMethod("selectByPrimaryKey", id.getClass())
                    .invoke(mapper, id);
        } catch (Exception e) {
            throw new DAOException(e);
        }
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
        Assert.notNull(recordWithBlobs, "对象为空");
        try {
            return (int)mapper.getClass()
                    .getDeclaredMethod("updateByExampleSelective", recordWithBlobs.getClass(), example.getClass())
                    .invoke(mapper, recordWithBlobs, example);
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
        Assert.notNull(recordWithBlobs, "对象为空");
        try {
            return (int)mapper.getClass()
                    .getDeclaredMethod("updateByExampleWithBLOBs", recordWithBlobs.getClass(), example.getClass())
                    .invoke(mapper, recordWithBlobs, example);
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
        Assert.notNull(record, "对象为空");
        try {
            return (int)mapper.getClass()
                    .getDeclaredMethod("updateByExample", record.getClass(), example.getClass())
                    .invoke(mapper, record, example);
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
        Assert.notNull(recordWithBlobs, "对象为空");
        try {
            return (int)mapper.getClass()
                    .getDeclaredMethod("updateByPrimaryKeySelective", recordWithBlobs.getClass())
                    .invoke(mapper, recordWithBlobs);
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
        Assert.notNull(recordWithBlobs, "对象为空");
        try {
            return (int)mapper.getClass()
                    .getDeclaredMethod("updateByPrimaryKeyWithBLOBs", recordWithBlobs.getClass())
                    .invoke(mapper, recordWithBlobs);
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
        Assert.notNull(record, "对象为空");
        try {
            return (int)mapper.getClass()
                    .getDeclaredMethod("updateByPrimaryKey", record.getClass())
                    .invoke(mapper, record);
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
    public boolean deleteByPrimaryKeyWithCatch(Integer id) {
        Assert.notNull(id, "条件对象为空");
        try {
            if ((int)mapper.getClass()
                    .getDeclaredMethod("deleteByPrimaryKey", id.getClass())
                    .invoke(mapper, id) == 1) {
                return true;
            }
        } catch (Exception e) {
            log.error(id + "_" + e.getMessage(), e);
        }
        return false;
    }

    /**
     * 插入记录
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public boolean insertWithCatch(RecordWithBlobs recordWithBlobs) {
        Assert.notNull(recordWithBlobs, "对象为空");
        try {
            if ((int)mapper.getClass()
                    .getDeclaredMethod("insert", recordWithBlobs.getClass())
                    .invoke(mapper, recordWithBlobs) == 1) {
                return true;
            }
        } catch (Exception e) {
            log.error(recordWithBlobs.toString() + "_" + e.getMessage(), e);
        }
        return false;
    }

    /**
     * 插入记录有效字段
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public boolean insertSelectiveWithCatch(RecordWithBlobs recordWithBlobs) {
        Assert.notNull(recordWithBlobs, "对象为空");
        try {
            if ((int)mapper.getClass()
                    .getDeclaredMethod("insertSelective", recordWithBlobs.getClass())
                    .invoke(mapper, recordWithBlobs) == 1) {
                return true;
            }
        } catch (Exception e) {
            log.error(recordWithBlobs.toString() + "_" + e.getMessage(), e);
        }
        return false;
    }

    /**
     * 根据条件查询记录
     *
     * @param example
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<RecordWithBlobs> selectByExampleWithBLOBsWithCatch(Example example) {
        Assert.notNull(example, "条件对象为空");
        try {
            return (List<RecordWithBlobs>)mapper.getClass()
                    .getDeclaredMethod("selectByExampleWithBLOBs", example.getClass())
                    .invoke(mapper, example);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 根据条件查询记录
     *
     * @param example
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Record> selectByExampleWithCatch(Example example) {
        Assert.notNull(example, "条件对象为空");
        try {
            return (List<Record>)mapper.getClass()
                    .getDeclaredMethod("selectByExample", example.getClass())
                    .invoke(mapper, example);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 根据主键查询记录
     *
     * @param id
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public RecordWithBlobs selectByPrimaryKeyWithCatch(Integer id) {
        Assert.notNull(id, "条件对象为空");
        try {
            return (RecordWithBlobs)mapper.getClass()
                    .getDeclaredMethod("selectByPrimaryKey", id.getClass())
                    .invoke(mapper, id);
        } catch (Exception e) {
            log.error(id + "_" + e.getMessage(), e);
        }
        return null;
    }

    /**
     * 根据主键更新记录有效字段
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public boolean updateByPrimaryKeySelectiveWithCatch(RecordWithBlobs recordWithBlobs) {
        Assert.notNull(recordWithBlobs, "对象为空");
        try {
            if ((int)mapper.getClass()
                    .getDeclaredMethod("updateByPrimaryKeySelective", recordWithBlobs.getClass())
                    .invoke(mapper, recordWithBlobs) == 1) {
                return true;
            }
        } catch (Exception e) {
            log.error(recordWithBlobs.toString() + "_" + e.getMessage(), e);
        }
        return false;
    }

    /**
     * 根据主键更新记录，附带BLOB字段
     *
     * @param recordWithBlobs
     * @return
     */
    @Override
    public boolean updateByPrimaryKeyWithBLOBsWithCatch(RecordWithBlobs recordWithBlobs) {
        Assert.notNull(recordWithBlobs, "对象为空");
        try {
            if ((int)mapper.getClass()
                    .getDeclaredMethod("updateByPrimaryKeyWithBLOBs", recordWithBlobs.getClass())
                    .invoke(mapper, recordWithBlobs) == 1) {
                return true;
            }
        } catch (Exception e) {
            log.error(recordWithBlobs.toString() + "_" + e.getMessage(), e);
        }
        return false;
    }

    /**
     * 根据主键更新记录
     *
     * @param record
     * @return
     */
    @Override
    public boolean updateByPrimaryKeyWithCatch(Record record) {
        Assert.notNull(record, "对象为空");
        try {
            if ((int)mapper.getClass()
                    .getDeclaredMethod("updateByPrimaryKey", record.getClass())
                    .invoke(mapper, record) == 1) {
                return true;
            }
        } catch (Exception e) {
            log.error(record.toString() + "_" + e.getMessage(), e);
        }
        return false;
    }

    /**
     * 查询全部，附带BLOB字段
     *
     * @param exampleClass
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<RecordWithBlobs> listAll(Class<Example> exampleClass) {
        Assert.notNull(exampleClass, "对象为空");
        try {
            return (List<RecordWithBlobs>) mapper.getClass()
                    .getDeclaredMethod("selectByExampleWithBLOBs", exampleClass)
                    .invoke(mapper, new Object[]{null});
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    /**
     * 查询全部，附带BLOB字段
     *
     * @param exampleClass
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<RecordWithBlobs> listAllWithCatch(Class<Example> exampleClass) {
        Assert.notNull(exampleClass, "对象为空");
        try {
            return (List<RecordWithBlobs>) mapper.getClass()
                    .getDeclaredMethod("selectByExampleWithBLOBs", exampleClass)
                    .invoke(mapper, new Object[]{null});
        } catch (Exception e) {
            log.error(exampleClass.getName() + "_" + e.getMessage(), e);
        }
        return null;
    }

    /**
     * 根据条件查询第一条记录
     *
     * @param example
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public Record selectFirstByExample(Example example) {
        Assert.notNull(example, "条件对象为空");
        try {
            List<Record> result = selectByExample(example);
            if (null != result && !result.isEmpty()) {
                return result.get(0);
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return null;
    }

    /**
     * 根据条件查询第一条记录，附带BLOB字段
     *
     * @param example
     * @return
     */
    @Override
    public RecordWithBlobs selectFirstByExampleWithBLOBs(Example example) {
        Assert.notNull(example, "条件对象为空");
        try {
            List<RecordWithBlobs> result = selectByExampleWithBLOBs(example);
            if (null != result && !result.isEmpty()) {
                return result.get(0);
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return null;
    }

    /**
     * 根据条件查询第一条记录
     *
     * @param example
     * @return
     */
    @Override
    public Record selectFirstByExampleWithCatch(Example example) {
        Assert.notNull(example, "条件对象为空");
        try {
            List<Record> result = selectByExample(example);
            if (null != result && !result.isEmpty()) {
                return result.get(0);
            }
        } catch (Exception e) {
            log.error(example.getClass().getName() + "_" + e.getMessage(), e);
        }
        return null;
    }

    /**
     * 根据条件查询第一条记录，附带BLOB字段
     *
     * @param example
     * @return
     */
    @Override
    public RecordWithBlobs selectFirstByExampleWithBLOBsWithCatch(Example example) {
        Assert.notNull(example, "条件对象为空");
        try {
            List<RecordWithBlobs> result = selectByExampleWithBLOBs(example);
            if (null != result && !result.isEmpty()) {
                return result.get(0);
            }
        } catch (Exception e) {
            log.error(example.getClass().getName() + "_" + e.getMessage(), e);
        }
        return null;
    }
}