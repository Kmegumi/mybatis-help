package com.megumi.core.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * BaseService接口
 * @author megumi
 * @date 2018/06/06.
 */
public interface BaseService<Record extends BaseEntity, Example extends BaseExample> {

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
    int deleteByPrimaryKey(Long id);

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
     * 根据条件查询记录，附带BLOB字段
     * @param example
     * @return
     */
    List<Record> selectByExampleWithBLOBs(Example example);

    /**
     * 根据条件查询记录
     * @param example
     * @return
     */
    List<Record> selectByExample(Example example);

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
    Record selectFirstByExampleWithBLOBs(Example example);

    /**
     * 根据主键查询记录
     * @param id
     * @return
     */
    Record selectByPrimaryKey(Long id);

    /**
     *
     * */
    int updateByPrimaryKeyAndVersion(@Param("record") Record record, Class<Example> exampleClass);

    /**
     * 根据条件更新有效字段
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

    /**
     * 根据条件更新记录有效字段，附带BLOB字段
     * @param record
     * @param example
     * @return
     */
    int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") Example example);

    /**
     * 根据条件更新记录
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Record record, @Param("example") Example example);

    /**
     * 根据主键更新记录有效字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Record record);

    /**
     * 根据主键更新记录，附带BLOB字段
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(Record record);

    /**
     * 根据主键更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Record record);


}