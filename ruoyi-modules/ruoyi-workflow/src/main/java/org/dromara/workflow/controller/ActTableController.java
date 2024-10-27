package org.dromara.workflow.controller;

import lombok.RequiredArgsConstructor;
import org.dromara.common.mybatis.core.page.PageQuery;

import org.dromara.common.web.core.BaseController;
import org.dromara.workflow.domain.WfTable;
import org.dromara.workflow.domain.bo.ModelBo;
import org.dromara.workflow.service.impl.WfTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/workflow/table")
public class ActTableController extends BaseController {
    @Autowired
    WfTableServiceImpl wfTableService;

    /**
     * 分页查询模型
     *
     * @param modelBo 模型参数
     */
    @GetMapping("/list")
    public List<WfTable> page(ModelBo modelBo, PageQuery pageQuery) {
        return wfTableService.Tables();
    }
}
