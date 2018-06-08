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

    private Date createDateTime;

    private Date lastUpdateDateTime;

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

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Date lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", version=" + version +
                ", createDateTime=" + createDateTime +
                ", lastUpdateDateTime=" + lastUpdateDateTime +
                '}';
    }
}
