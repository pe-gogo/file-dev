package com.file.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.file.common.core.domain.BaseEntity;

/**
 * 评教对象 rating
 *
 * @author file
 * @date 2023-03-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("rating")
public class Rating extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 评价id
     */
    @TableId(value = "rating_id")
    private String ratingId;
    /**
     * 平均分
     */
    private String avg;
    /**
     * 最高
     */
    private String max;
    /**
     * 最低
     */
    private String min;
    /**
     * 详情
     */
    private String detail;
    /**
     * 总分
     */
    private String total;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 课程id
     */
    private String cousersId;
    /**
     * 建议
     */
    private String advice;

}
