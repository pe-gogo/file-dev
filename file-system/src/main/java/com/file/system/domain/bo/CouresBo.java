package com.file.system.domain.bo;

import com.file.common.core.validate.AddGroup;
import com.file.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.file.common.core.domain.BaseEntity;

/**
 * 课程业务对象 coures
 *
 * @author file
 * @date 2023-03-21
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class CouresBo extends BaseEntity {

    /**
     * id
     */
    @NotBlank(message = "id不能为空", groups = { EditGroup.class })
    private String couresId;

    /**
     * 名字
     */
    @NotBlank(message = "名字不能为空", groups = { AddGroup.class, EditGroup.class })
    private String name;

    /**
     * 教师课程
     */
    @NotBlank(message = "教师课程不能为空", groups = { AddGroup.class, EditGroup.class })
    private String userId;


}
