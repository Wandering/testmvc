package cn.bwl.service.impl;

import cn.bwl.dao.ITestDAO;
import cn.bwl.domain.TestDomain;
import cn.bwl.service.ITestServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("TestServiceImpl")
public class TestServiceImpl implements ITestServcie {
    @Autowired
    private ITestDAO testDAO;
    @Override
    public List<TestDomain> queryList(Map<String, Object> map) {
        return testDAO.queryList(map);
    }
}
