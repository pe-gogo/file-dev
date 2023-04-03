package com.file.system.service;

import com.file.system.domain.Rating;
import com.file.system.domain.vo.RatingVo;
import com.file.system.domain.bo.RatingBo;
import com.file.common.core.page.TableDataInfo;
import com.file.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 评教Service接口
 *
 * @author file
 * @date 2023-03-29
 */
public interface IRatingService {

    /**
     * 查询评教
     */
    RatingVo queryById(String ratingId);

    /**
     * 查询评教列表
     */
    TableDataInfo<RatingVo> queryPageList(RatingBo bo, PageQuery pageQuery);

    /**
     * 查询评教列表
     */
    List<RatingVo> queryList(RatingBo bo);

    /**
     * 新增评教
     */
    Boolean insertByBo(RatingBo bo);

    /**
     * 修改评教
     */
    Boolean updateByBo(RatingBo bo);

    /**
     * 校验并批量删除评教信息
     */
    Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid);
}
