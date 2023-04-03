package com.file.system.domain.bo;

import com.file.common.core.validate.AddGroup;
import com.file.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.file.common.core.domain.BaseEntity;

/**
 * 评教业务对象 rating
 *
 * @author file
 * @date 2023-03-29
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class RatingBo extends BaseEntity {

    /**
     * 评价id
     */
    @NotBlank(message = "评价id不能为空", groups = { EditGroup.class })
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
    @NotBlank(message = "详情不能为空", groups = { AddGroup.class, EditGroup.class })
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
    @NotBlank(message = "课程id不能为空", groups = { AddGroup.class, EditGroup.class })
    private String cousersId;

    /**
     * 建议
     */
    private String advice;


}
