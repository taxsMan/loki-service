package org.dromara.workflow.mapper;

import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;
import org.dromara.workflow.domain.TestLeave;
import org.dromara.workflow.domain.vo.TestLeaveVo;
import org.springframework.stereotype.Repository;

/**
 * 请假Mapper接口
 *
 * @author may
 * @date 2023-07-21
 */
@Repository
public interface TestLeaveMapper extends BaseMapperPlus<TestLeave, TestLeaveVo> {

}
