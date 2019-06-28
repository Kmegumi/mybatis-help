package com.megumi.core.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * BaseService接口
 * @author megumi
 * @date 2018/06/06.
 */
public interface BaseServiceWithBLOBs<Record, RecordWithBlobs extends Record, Example> {

    /****************正常查询方法***************/

    /**
     * 根据条件查询记录数量
     * @param example
     * @return
     */
    long countByExample(Example example);

    /**
     * 根据条件删除记录
     * @param example
     * @return
     */
    int deleteByExample(Example example);

    /**
     * 根据主键删除记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入记录
     * @param recordWithBlobs
     * @return
     */
    int insert(RecordWithBlobs recordWithBlobs, Class<Record> recordClass);

    /**
     * 插入记录有效字段
     * @param recordWithBlobs
     * @return
     */
    int insertSelective(RecordWithBlobs recordWithBlobs, Class<Record> recordClass);

    /**
     * 插入记录
     * @param recordWithBlobs
     * @return
     */
    int insert(RecordWithBlobs recordWithBlobs);

    /**
     * 插入记录有效字段
     * @param recordWithBlobs
     * @return
     */
    int insertSelective(RecordWithBlobs recordWithBlobs);

    /**
     * 根据条件查询记录，附带BLOB字段
     * @param example
     * @return
     */
    List<RecordWithBlobs> selectByExampleWithBLOBs(Example example);

    /**
     * 根据条件查询记录
     * @param example
     * @return
     */
    List<Record> selectByExample(Example example);

    /**
     * 根据主键查询记录
     * @param id
     * @return
     */
    RecordWithBlobs selectByPrimaryKey(Integer id);

    /**
     * 根据条件更新有效字段
     * @param recordWithBlobs
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") RecordWithBlobs recordWithBlobs, Class<Record> recordClass, @Param("example") Example example);

    /**
     * 根据条件更新记录有效字段，附带BLOB字段
     * @param recordWithBlobs
     * @param example
     * @return
     */
    int updateByExampleWithBLOBs(@Param("record") RecordWithBlobs recordWithBlobs, Class<Record> recordClass, @Param("example") Example example);

    /**
     * 根据条件更新记录
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Record record, Class<Record> recordClass, @Param("example") Example example);

    /**
     * 根据主键更新记录有效字段
     * @param recordWithBlobs
     * @return
     */
    int updateByPrimaryKeySelective(RecordWithBlobs recordWithBlobs, Class<Record> recordClass);

    /**
     * 根据主键更新记录，附带BLOB字段
     * @param recordWithBlobs
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(RecordWithBlobs recordWithBlobs, Class<Record> recordClass);

    /**
     * 根据主键更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Record record, Class<Record> recordClass);

    /**
     * 根据条件更新有效字段
     * @param recordWithBlobs
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") RecordWithBlobs recordWithBlobs, @Param("example") Example example);

    /**
     * 根据条件更新记录有效字段，附带BLOB字段
     * @param recordWithBlobs
     * @param example
     * @return
     */
    int updateByExampleWithBLOBs(@Param("record") RecordWithBlobs recordWithBlobs, @Param("example") Example example);

    /**
     * 根据条件更新记录
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Record record, @Param("example") Example example);

    /**
     * 根据主键更新记录有效字段
     * @param recordWithBlobs
     * @return
     */
    int updateByPrimaryKeySelective(RecordWithBlobs recordWithBlobs);

    /**
     * 根据主键更新记录，附带BLOB字段
     * @param recordWithBlobs
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(RecordWithBlobs recordWithBlobs);

    /**
     * 根据主键更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Record record);


    /************************catch查询方法*****************************/


    /**
     * 根据主键删除记录
     * @param id
     * @return
     */
    boolean deleteByPrimaryKeyWithCatch(Integer id);

    /**
     * 插入记录
     * @param recordWithBlobs
     * @return
     */
    boolean insertWithCatch(RecordWithBlobs recordWithBlobs, Class<Record> recordClass);

    /**
     * 插入记录有效字段
     * @param recordWithBlobs
     * @return
     */
    boolean insertSelectiveWithCatch(RecordWithBlobs recordWithBlobs, Class<Record> recordClass);

    /**
     * 插入记录
     * @param recordWithBlobs
     * @return
     */
    boolean insertWithCatch(RecordWithBlobs recordWithBlobs);

    /**
     * 插入记录有效字段
     * @param recordWithBlobs
     * @return
     */
    boolean insertSelectiveWithCatch(RecordWithBlobs recordWithBlobs);


    /**
     * 根据条件查询记录
     * @param example
     * @return
     */
    List<RecordWithBlobs> selectByExampleWithBLOBsWithCatch(Example example);

    /**
     * 根据条件查询记录
     * @param example
     * @return
     */
    List<Record> selectByExampleWithCatch(Example example);

    /**
     * 根据主键查询记录
     * @param id
     * @return
     */
    RecordWithBlobs selectByPrimaryKeyWithCatch(Integer id);

    /**
     * 根据主键更新记录有效字段
     * @param recordWithBlobs
     * @return
     */
    boolean updateByPrimaryKeySelectiveWithCatch(RecordWithBlobs recordWithBlobs, Class<Record> recordClass);

    /**
     * 根据主键更新记录，附带BLOB字段
     * @param recordWithBlobs
     * @return
     */
    boolean updateByPrimaryKeyWithBLOBsWithCatch(RecordWithBlobs recordWithBlobs, Class<Record> recordClass);

    /**
     * 根据主键更新记录有效字段
     * @param recordWithBlobs
     * @return
     */
    boolean updateByPrimaryKeySelectiveWithCatch(RecordWithBlobs recordWithBlobs);

    /**
     * 根据主键更新记录，附带BLOB字段
     * @param recordWithBlobs
     * @return
     */
    boolean updateByPrimaryKeyWithBLOBsWithCatch(RecordWithBlobs recordWithBlobs);

    /**
     * 根据主键更新记录
     * @param record
     * @return
     */
    boolean updateByPrimaryKeyWithCatch(Record record);



    /***********************特殊方法******************************/


    /**
     * 查询全部，附带BLOB字段
     * @param exampleClass
     * @return
     */
    List<RecordWithBlobs> listAll(Class<Example> exampleClass);

    /**
     * 查询全部，附带BLOB字段
     * @param exampleClass
     * @return
     */
    List<RecordWithBlobs> listAllWithCatch(Class<Example> exampleClass);

    /**
     * 根据条件查询第一条记录
     * @param example
     * @return
     */
    Record selectFirstByExample(Example example);

    /**
     * 根据条件查询第一条记录，附带BLOB字段
     * @param example
     * @return
     */
    RecordWithBlobs selectFirstByExampleWithBLOBs(Example example);


    /**
     * 根据条件查询第一条记录
     * @param example
     * @return
     */
    Record selectFirstByExampleWithCatch(Example example);

    /**
     * 根据条件查询第一条记录，附带BLOB字段
     * @param example
     * @return
     */
    RecordWithBlobs selectFirstByExampleWithBLOBsWithCatch(Example example);


}