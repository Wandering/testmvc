package cn.bwl.service.impl;

import cn.bwl.dao.ICarDAO;
import cn.bwl.dao.ITestDAO;
import cn.bwl.domain.TestDomain;
import cn.bwl.service.ICarServcie;
import cn.bwl.service.ITestServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CarServiceImpl")
public class CarServiceImpl implements ICarServcie {
    @Autowired
    private ICarDAO carDAO;

    @Override
    public List<Map<String, Object>> bannerQueryList() {
        return carDAO.bannerQueryList();
    }

    @Override
    public List<Map<String, Object>> newsQueryList() {
        return carDAO.newsQueryList();
    }

    @Override
    public List<Map<String, Object>> photosQueryList() {
        return carDAO.photosQueryList();
    }

    @Override
    public List<Map<String, Object>> servicesQueryList() {
        return carDAO.servicesQueryList();
    }
}
