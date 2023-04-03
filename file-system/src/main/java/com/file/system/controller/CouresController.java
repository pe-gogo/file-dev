package com.file.system.controller;

import java.util.List;
import java.util.Arrays;

import lombok.RequiredArgsConstructor;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.file.common.annotation.RepeatSubmit;
import com.file.common.annotation.Log;
import com.file.common.core.controller.BaseController;
import com.file.common.core.domain.PageQuery;
import com.file.common.core.domain.R;
import com.file.common.core.validate.AddGroup;
import com.file.common.core.validate.EditGroup;
import com.file.common.enums.BusinessType;
import com.file.common.utils.poi.ExcelUtil;
import com.file.system.domain.vo.CouresVo;
import com.file.system.domain.bo.CouresBo;
import com.file.system.service.ICouresService;
import com.file.common.core.page.TableDataInfo;

/**
 * 课程
 *
 * @author file
 * @date 2023-03-21
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/course")
public class CouresController extends BaseController {

    private final ICouresService iCouresService;

    /**
     * 查询课程列表
     */
    @SaCheckPermission("system:course:list")
    @GetMapping("/list")
    public TableDataInfo<CouresVo> list(CouresBo bo, PageQuery pageQuery) {
        return iCouresService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出课程列表
     */
    @SaCheckPermission("system:course:export")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CouresBo bo, HttpServletResponse response) {
        List<CouresVo> list = iCouresService.queryList(bo);
        ExcelUtil.exportExcel(list, "课程", CouresVo.class, response);
    }

    /**
     * 获取课程详细信息
     *
     * @param couresId 主键
     */
    @SaCheckPermission("system:course:query")
    @GetMapping("/{couresId}")
    public R<CouresVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable String couresId) {
        return R.ok(iCouresService.queryById(couresId));
    }

    /**
     * 新增课程
     */
    @SaCheckPermission("system:course:add")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CouresBo bo) {
        return toAjax(iCouresService.insertByBo(bo));
    }

    /**
     * 修改课程
     */
    @SaCheckPermission("system:course:edit")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CouresBo bo) {
        return toAjax(iCouresService.updateByBo(bo));
    }

    /**
     * 删除课程
     *
     * @param couresIds 主键串
     */
    @SaCheckPermission("system:course:remove")
    @Log(title = "课程", businessType = BusinessType.DELETE)
    @DeleteMapping("/{couresIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable String[] couresIds) {
        return toAjax(iCouresService.deleteWithValidByIds(Arrays.asList(couresIds), true));
    }

    @SaCheckPermission("system:course:list")
    @GetMapping("/list/{uid}")
    public List<CouresVo> listByuid(@PathVariable String uid, PageQuery pageQuery) {
        return iCouresService.getById(uid);
    }
}
