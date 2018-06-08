package com.megumi.core.base;


/**
 * @author megumi
 * @date 2018/6/6
 */
public interface BaseGeneratedCriteria<T extends BaseGeneratedCriteria> {

    T andIdEqualTo(Long value);

    T andVersionEqualTo(Long value);
}
