package com.file.system.service;

import com.file.system.domain.Coures;
import com.file.system.domain.vo.CouresVo;
import com.file.system.domain.bo.CouresBo;
import com.file.common.core.page.TableDataInfo;
import com.file.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 课程Service接口
 *
 * @author file
 * @date 2023-03-21
 */
public interface ICouresService {

    /**
     * 查询课程
     */
    CouresVo queryById(String couresId);

    /**
     * 查询课程列表
     */
    TableDataInfo<CouresVo> queryPageList(CouresBo bo, PageQuery pageQuery);

    /**
     * 查询课程列表
     */
    List<CouresVo> queryList(CouresBo bo);

    /**
     * 新增课程
     */
    Boolean insertByBo(CouresBo bo);

    /**
     * 修改课程
     */
    Boolean updateByBo(CouresBo bo);

    /**
     * 校验并批量删除课程信息
     */
    Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid);

    List<CouresVo> getById(String uid);
}
