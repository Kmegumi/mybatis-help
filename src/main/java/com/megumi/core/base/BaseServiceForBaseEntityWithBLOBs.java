package com.megumi.core.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * BaseService接口
 * @author megumi
 * @date 2018/06/06.
 */
public interface BaseServiceForBaseEntityWithBLOBs<Record extends BaseEntity, RecordWithBlobs extends Record, Example extends BaseExample> extends BaseServiceWithBLOBs<Record, RecordWithBlobs, Example> {


    /**
     * 根据版本号修改对象
     * @param recordWithBlobs
     * @param exampleClass
     * */
    boolean updateByPrimaryKeyAndVersion(RecordWithBlobs recordWithBlobs, Class<Example> exampleClass);


    /**
     * 根据版本号修改对象
     * @param recordWithBlobs
     * @param exampleClass
     * */
    boolean updateByPrimaryKeyAndVersionWithCatch(RecordWithBlobs recordWithBlobs, Class<Example> exampleClass);


}