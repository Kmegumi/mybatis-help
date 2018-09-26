package com.megumi.core.base;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 基类
 * @author megumi
 * @date 2018/4/26
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class BaseEntity implements Serializable {

    private Integer id;

    private Integer version;

    private LocalDateTime createDatetime;

    private LocalDateTime lastUpdateDatetime;
}
