package com.file.demo.mapper;

import com.file.common.annotation.DataColumn;
import com.file.common.annotation.DataPermission;
import com.file.common.core.mapper.BaseMapperPlus;
import com.file.demo.domain.TestTree;
import com.file.demo.domain.vo.TestTreeVo;

/**
 * 测试树表Mapper接口
 *
 * @author Lion Li
 * @date 2021-07-26
 */
@DataPermission({
    @DataColumn(key = "deptName", value = "dept_id"),
    @DataColumn(key = "userName", value = "user_id")
})
public interface TestTreeMapper extends BaseMapperPlus<TestTreeMapper, TestTree, TestTreeVo> {

}
