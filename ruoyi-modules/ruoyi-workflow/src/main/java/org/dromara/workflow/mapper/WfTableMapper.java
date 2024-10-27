package org.dromara.workflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.dromara.workflow.domain.WfTable;

import java.util.List;

@Mapper
public interface WfTableMapper {

    /**
     * 排除ACT开头的数据表
     * 排除FLW开头的数据表
     * 排除sys开头的数据表
     * 排除wf开头的数据
     * 排除gen开头的数据
     */
    @Select(
        "SELECT * FROM information_schema.Tables WHERE TABLE_SCHEMA=(SELECT database())" +
            "AND TABLE_NAME NOT LIKE 'ACT_%' " +
            "AND TABLE_NAME NOT LIKE 'FLW_%' " +
            "AND TABLE_NAME NOT LIKE 'sys_%' " +
            "AND TABLE_NAME NOT LIKE 'gen_%' " +
            "AND TABLE_NAME NOT LIKE 'wf_%' "
    )
    @Results(
        value = {
            @Result(property = "TABLE_NAME", column = "TABLE_NAME"),
            @Result(property = "TABLE_COMMENT", column = "TABLE_COMMENT")
        }
    )
    List<WfTable> tables();
}
