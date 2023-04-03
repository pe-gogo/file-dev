package com.file.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.file.common.annotation.ExcelDictFormat;
import com.file.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 课程视图对象 coures
 *
 * @author file
 * @date 2023-03-21
 */
@Data
@ExcelIgnoreUnannotated
public class CouresVo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private String couresId;

    /**
     * 名字
     */
    @ExcelProperty(value = "名字")
    private String name;

    /**
     * 教师课程
     */
    @ExcelProperty(value = "教师课程")
    private String userId;


}
