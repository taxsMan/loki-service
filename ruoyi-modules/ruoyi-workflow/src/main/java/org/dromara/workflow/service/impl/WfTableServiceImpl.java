package org.dromara.workflow.service.impl;

import org.dromara.workflow.domain.WfTable;
import org.dromara.workflow.mapper.WfTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WfTableServiceImpl {
    @Autowired
    WfTableMapper tableDaoMapper;

    public List<WfTable> Tables() {
        return tableDaoMapper.tables();
    }
}
