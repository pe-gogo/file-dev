package com.file.system.controller;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.SaTokenInfo;
import com.file.system.domain.Rating;
import com.file.system.domain.dto.UserRole;
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
import com.file.common.core.validate.QueryGroup;
import com.file.common.enums.BusinessType;
import com.file.common.utils.poi.ExcelUtil;
import com.file.system.domain.vo.RatingVo;
import com.file.system.domain.bo.RatingBo;
import com.file.system.service.IRatingService;
import com.file.common.core.page.TableDataInfo;

/**
 * 评教
 *
 * @author file
 * @date 2023-03-29
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/rating")
public class RatingController extends BaseController {

    private final IRatingService iRatingService;

    /**
     * 查询评教列表
     */
    @SaCheckPermission("system:rating:list")
    @GetMapping("/list")
    public TableDataInfo<RatingVo> list(RatingBo bo, PageQuery pageQuery) {
        return iRatingService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出评教列表
     */
    @SaCheckPermission("system:rating:export")
    @Log(title = "评教", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(RatingBo bo, HttpServletResponse response) {
        List<RatingVo> list = iRatingService.queryList(bo);
        ExcelUtil.exportExcel(list, "评教", RatingVo.class, response);
    }

    /**
     * 获取评教详细信息
     *
     * @param ratingId 主键
     */
    @SaCheckPermission("system:rating:query")
    @GetMapping("/{ratingId}")
    public R<RatingVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable String ratingId) {
        return R.ok(iRatingService.queryById(ratingId));
    }

    /**
     * 新增评教
     */
    @SaCheckPermission("system:rating:add")
    @Log(title = "评教", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody RatingBo bo) {
        return toAjax(iRatingService.insertByBo(bo));
    }

    /**
     * 修改评教
     */
    @SaCheckPermission("system:rating:edit")
    @Log(title = "评教", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody RatingBo bo) {
        return toAjax(iRatingService.updateByBo(bo));
    }

    /**
     * 删除评教
     *
     * @param ratingIds 主键串
     */
    @SaCheckPermission("system:rating:remove")
    @Log(title = "评教", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ratingIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable String[] ratingIds) {
        return toAjax(iRatingService.deleteWithValidByIds(Arrays.asList(ratingIds), true));
    }

    @SaCheckPermission("system:rating:query")
    public R<RatingVo> getCouresaInfo(@NotNull(message = "主键不能为空")
                               @PathVariable String ratingId) {
        //获取当前用户信息
        SaTokenInfo saTokenInfo = new SaTokenInfo();
        System.out.println(saTokenInfo.getLoginId());
        return R.ok(iRatingService.queryById(ratingId));
    }

    @GetMapping("/list/{id}")
    public R<List<Rating>> getCouresaInfoById(@PathVariable String id){
        //获取当前用户信息
        return R.ok(iRatingService.queryByCousersId(id));
    }

    @GetMapping("/echart/{courseId}")
    @SaIgnore
    public R<List<UserRole>> getEchart(@PathVariable String courseId){
        //获取当前用户信息
        return R.ok(iRatingService.queryByUserId(courseId));
    }

}
