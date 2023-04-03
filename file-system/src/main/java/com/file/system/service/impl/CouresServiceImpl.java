package com.file.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.file.common.utils.StringUtils;
import com.file.common.core.page.TableDataInfo;
import com.file.common.core.domain.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.file.system.domain.bo.CouresBo;
import com.file.system.domain.vo.CouresVo;
import com.file.system.domain.Coures;
import com.file.system.mapper.CouresMapper;
import com.file.system.service.ICouresService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 课程Service业务层处理
 *
 * @author file
 * @date 2023-03-21
 */
@RequiredArgsConstructor
@Service
public class CouresServiceImpl implements ICouresService {

    private final CouresMapper baseMapper;

    /**
     * 查询课程
     */
    @Override
    public CouresVo queryById(String couresId){
        return baseMapper.selectVoById(couresId);
    }

    /**
     * 查询课程列表
     */
    @Override
    public TableDataInfo<CouresVo> queryPageList(CouresBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Coures> lqw = buildQueryWrapper(bo);
        Page<CouresVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询课程列表
     */
    @Override
    public List<CouresVo> queryList(CouresBo bo) {
        LambdaQueryWrapper<Coures> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Coures> buildQueryWrapper(CouresBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Coures> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getName()), Coures::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getUserId()), Coures::getUserId, bo.getUserId());
        return lqw;
    }

    /**
     * 新增课程
     */
    @Override
    public Boolean insertByBo(CouresBo bo) {
        Coures add = BeanUtil.toBean(bo, Coures.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setCouresId(add.getCouresId());
        }
        return flag;
    }

    /**
     * 修改课程
     */
    @Override
    public Boolean updateByBo(CouresBo bo) {
        Coures update = BeanUtil.toBean(bo, Coures.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(Coures entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除课程
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    public List<CouresVo> getById(String uid){
        return baseMapper.selectVoList(new QueryWrapper<Coures>().eq("user_id", uid));
    }
}
