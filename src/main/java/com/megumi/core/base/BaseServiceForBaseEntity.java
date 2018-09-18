package com.megumi.core.base;


/**
 * BaseService接口
 * @author megumi
 * @date 2018/06/06.
 */
public interface BaseServiceForBaseEntity<Record extends BaseEntity, Example extends BaseExample> extends BaseService<Record, Example> {

    /**
     * 根据版本号修改对象
     * @param record
     * @param exampleClass
     * @return
     */
    boolean updateByPrimaryKeyAndVersion(Record record, Class<Example> exampleClass);
}