package com.file.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.file.common.core.domain.BaseEntity;

/**
 * 课程对象 coures
 *
 * @author file
 * @date 2023-03-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("coures")
public class Coures extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "coures_id")
    private String couresId;
    /**
     * 名字
     */
    private String name;
    /**
     * 教师课程
     */
    private String userId;

}
