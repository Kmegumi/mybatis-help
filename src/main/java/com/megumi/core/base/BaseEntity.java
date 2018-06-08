package com.megumi.core.base;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基类
 * @author megumi
 * @date 2018/4/26
 */
public class BaseEntity implements Serializable {

    private Long id;

    private Long version;

    private LocalDateTime createTime;

    private LocalDateTime lastUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", version=" + version +
                ", createTime=" + createTime +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
