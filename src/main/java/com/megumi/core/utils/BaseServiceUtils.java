package com.megumi.core.utils;

import com.megumi.core.base.BaseEntity;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * @author megumi
 * @date 2018/9/15
 */
public class BaseServiceUtils {


    public static <T extends BaseEntity> void initInsert(T t) {
        Assert.notNull(t, "对象为空");
        t.setId(null);
        t.setVersion(0);
        Date now = new Date();
        t.setCreateDatetime(now);
        t.setLastUpdateDatetime(now);
    }

    public static <T extends BaseEntity> void initUpdate(T t) {
        Assert.notNull(t, "对象为空");
        t.setLastUpdateDatetime(new Date());
    }

}
