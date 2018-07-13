package com.megumi.core.base;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 基类
 * @author megumi
 * @date 2018/4/26
 */
public class BaseEntity implements Serializable {

    private Integer id;

    private Integer version;

    private Date createDatetime;

    private Date lastUpdateDatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getLastUpdateDatetime() {
        return lastUpdateDatetime;
    }

    public void setLastUpdateDatetime(Date lastUpdateDatetime) {
        this.lastUpdateDatetime = lastUpdateDatetime;
    }
}
