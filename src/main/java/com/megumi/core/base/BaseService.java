package com.megumi.core.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * BaseService接口
 * @author megumi
 * @date 2018/06/06.
 */
public interface BaseService<Record, Example> {

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
     * @param record
     * @return
     */
    int insert(Record record, Class<Record> recordClass);

    /**
     * 插入记录有效字段
     * @param record
     * @return
     */
    int insertSelective(Record record, Class<Record> recordClass);

    /**
     * 插入记录
     * @param record
     * @return
     */
    int insert(Record record);

    /**
     * 插入记录有效字段
     * @param record
     * @return
     */
    int insertSelective(Record record);

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
    Record selectByPrimaryKey(Integer id);

    /**
     * 根据条件更新有效字段
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

    /**
     * 根据条件更新记录
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Record record, @Param("example") Example example);

    /**
     * 根据条件更新有效字段
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Record record, Class<Record> recordClass, @Param("example") Example example);

    /**
     * 根据条件更新记录
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Record record, Class<Record> recordClass, @Param("example") Example example);


    /**
     * 根据主键更新记录有效字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Record record);


    /**
     * 根据主键更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Record record);

    /**
     * 根据主键更新记录有效字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Record record, Class<Record> recordClass);


    /**
     * 根据主键更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Record record, Class<Record> recordClass);

    /**
     * 根据主键删除记录
     * @param id
     * @return
     */
    boolean deleteByPrimaryKeyWithCatch(Integer id);

    /**
     * 插入记录
     * @param record
     * @return
     */
    boolean insertWithCatch(Record record);

    /**
     * 插入记录有效字段
     * @param record
     * @return
     */
    boolean insertSelectiveWithCatch(Record record);

    /**
     * 插入记录
     * @param record
     * @return
     */
    boolean insertWithCatch(Record record, Class<Record> recordClass);

    /**
     * 插入记录有效字段
     * @param record
     * @return
     */
    boolean insertSelectiveWithCatch(Record record, Class<Record> recordClass);

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
    Record selectByPrimaryKeyWithCatch(Integer id);

    /**
     * 根据主键更新记录有效字段
     * @param record
     * @return
     */
    boolean updateByPrimaryKeySelectiveWithCatch(Record record);

    /**
     * 根据主键更新记录
     * @param record
     * @return
     */
    boolean updateByPrimaryKeyWithCatch(Record record);

    /**
     * 根据主键更新记录有效字段
     * @param record
     * @return
     */
    boolean updateByPrimaryKeySelectiveWithCatch(Record record, Class<Record> recordClass);

    /**
     * 根据主键更新记录
     * @param record
     * @return
     */
    boolean updateByPrimaryKeyWithCatch(Record record, Class<Record> recordClass);


    /**
     * 根据条件查询记录，附带BLOB字段
     * @param exampleClass Example的class对象
     * @return
     */
    List<Record> listAll(Class<Example> exampleClass);

    /**
     * 根据条件查询第一条记录
     * @param example
     * @return
     */
    Record selectFirstByExample(Example example);


    /**
     * 根据条件查询记录，附带BLOB字段
     * @param exampleClass Example的class对象
     * @return
     */
    List<Record> listAllWithCatch(Class<Example> exampleClass);

    /**
     * 根据条件查询第一条记录
     * @param example
     * @return
     */
    Record selectFirstByExampleWithCatch(Example example);

}