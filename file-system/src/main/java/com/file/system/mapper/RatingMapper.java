package com.file.system.mapper;

import com.file.system.domain.Rating;
import com.file.system.domain.dto.UserRole;
import com.file.system.domain.vo.RatingVo;
import com.file.common.core.mapper.BaseMapperPlus;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 评教Mapper接口
 *
 * @author file
 * @date 2023-03-29
 */
public interface RatingMapper extends BaseMapperPlus<RatingMapper, Rating, RatingVo> {



    List<UserRole> getUserRoleInfo(String cousersId);

}
