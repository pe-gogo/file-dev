package com.file.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.file.common.utils.StringUtils;
import com.file.common.core.page.TableDataInfo;
import com.file.common.core.domain.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.file.system.domain.dto.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.file.system.domain.bo.RatingBo;
import com.file.system.domain.vo.RatingVo;
import com.file.system.domain.Rating;
import com.file.system.mapper.RatingMapper;
import com.file.system.service.IRatingService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 评教Service业务层处理
 *
 * @author file
 * @date 2023-03-29
 */
@RequiredArgsConstructor
@Service
public class RatingServiceImpl implements IRatingService {

    private final RatingMapper baseMapper;

    /**
     * 查询评教
     */
    @Override
    public RatingVo queryById(String ratingId){
        return baseMapper.selectVoById(ratingId);
    }

    /**
     * 查询评教列表
     */
    @Override
    public TableDataInfo<RatingVo> queryPageList(RatingBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Rating> lqw = buildQueryWrapper(bo);
        Page<RatingVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询评教列表
     */
    @Override
    public List<RatingVo> queryList(RatingBo bo) {
        LambdaQueryWrapper<Rating> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Rating> buildQueryWrapper(RatingBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Rating> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getAvg()), Rating::getAvg, bo.getAvg());
        lqw.eq(StringUtils.isNotBlank(bo.getMax()), Rating::getMax, bo.getMax());
        lqw.eq(StringUtils.isNotBlank(bo.getMin()), Rating::getMin, bo.getMin());
        lqw.eq(StringUtils.isNotBlank(bo.getDetail()), Rating::getDetail, bo.getDetail());
        lqw.eq(StringUtils.isNotBlank(bo.getTotal()), Rating::getTotal, bo.getTotal());
        lqw.eq(StringUtils.isNotBlank(bo.getUserId()), Rating::getUserId, bo.getUserId());
        lqw.eq(StringUtils.isNotBlank(bo.getCousersId()), Rating::getCousersId, bo.getCousersId());
        lqw.eq(StringUtils.isNotBlank(bo.getAdvice()), Rating::getAdvice, bo.getAdvice());
        return lqw;
    }

    /**
     * 新增评教
     */
    @Override
    public Boolean insertByBo(RatingBo bo) {
        Rating add = BeanUtil.toBean(bo, Rating.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setRatingId(add.getRatingId());
        }
        return flag;
    }

    /**
     * 修改评教
     */
    @Override
    public Boolean updateByBo(RatingBo bo) {
        Rating update = BeanUtil.toBean(bo, Rating.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(Rating entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除评教
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }

//    查询当前课程评分
    @Override
    public List<Rating> queryByCousersId(String cousersId) {
        return baseMapper.selectList(new QueryWrapper<Rating>().eq("cousers_id", cousersId));
    }

//    查询当前课程评分分组
    @Override
    public List<UserRole> queryByUserId(String cousersId) {
        return baseMapper.getUserRoleInfo(cousersId);
    }
}
