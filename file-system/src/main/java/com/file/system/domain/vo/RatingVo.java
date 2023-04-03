package com.file.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.file.common.annotation.ExcelDictFormat;
import com.file.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 评教视图对象 rating
 *
 * @author file
 * @date 2023-03-29
 */
@Data
@ExcelIgnoreUnannotated
public class RatingVo {

    private static final long serialVersionUID = 1L;

    /**
     * 评价id
     */
    @ExcelProperty(value = "评价id")
    private String ratingId;

    /**
     * 平均分
     */
    @ExcelProperty(value = "平均分")
    private String avg;

    /**
     * 最高
     */
    @ExcelProperty(value = "最高")
    private String max;

    /**
     * 最低
     */
    @ExcelProperty(value = "最低")
    private String min;

    /**
     * 详情
     */
    @ExcelProperty(value = "详情")
    private String detail;

    /**
     * 总分
     */
    @ExcelProperty(value = "总分")
    private String total;

    /**
     * 用户id
     */
    @ExcelProperty(value = "用户id")
    private String userId;

    /**
     * 课程id
     */
    @ExcelProperty(value = "课程id")
    private String cousersId;

    /**
     * 建议
     */
    @ExcelProperty(value = "建议")
    private String advice;


}
