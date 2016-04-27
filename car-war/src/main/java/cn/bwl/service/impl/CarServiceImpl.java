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

    @Override
    public List<Map<String, Object>> newQueryPage(String orderBy, String sortBy, String offset, String rows) {
        return carDAO.newQueryPage(orderBy,sortBy,offset,rows);
    }
    @Override
    public Integer newQueryCount() {
        return carDAO.newQueryCount();
    }

    @Override
    public Map<String, Object> newQueryById(Object id) {
        return carDAO.newQueryById(id);
    }

    @Override
    public List<Map<String, Object>> carQueryPage(String orderBy, String sortBy, String offset, String rows, Map<String,Object> queryparam) {
        return carDAO.carQueryPage(orderBy, sortBy, offset, rows ,queryparam);
    }
    @Override
    public Integer carQueryCount() {
        return carDAO.carQueryCount();
    }

    @Override
    public Map<String, Object> carQueryById(Object id) {
        return carDAO.carQueryById(id);
    }
    @Override
    public List<Map<String, Object>> buyQueryPage(String orderBy, String sortBy, String offset, String rows) {
        return carDAO.buyQueryPage(orderBy, sortBy, offset, rows);
    }
    @Override
    public Integer buyQueryCount() {
        return carDAO.buyQueryCount();
    }

    @Override
    public Map<String, Object> buyQueryById(Object id) {
        return carDAO.buyQueryById(id);
    }
    @Override
    public boolean addBuy(Map<String, Object> map) {
        return carDAO.addBuy(map);
    }

    @Override
    public boolean login(Map<String, Object> map) {
        return carDAO.login(map);
    }

    @Override
    public boolean addNew(Map<String, Object> map) {
        return carDAO.addNew(map);
    }

    @Override
    public boolean addCar(Map<String, Object> map) {
        return carDAO.addCar(map);
    }

    @Override
    public boolean updateBuy(Map<String, Object> map) {
        return carDAO.updateBuy(map);

    }

    @Override
    public boolean updateNew(Map<String, Object> map) {
        return carDAO.updateNew(map);
    }

    @Override
    public boolean updateCar(Map<String, Object> map) {
        return carDAO.updateCar(map);
    }

    @Override
    public boolean deleteBuy(Object id) {
        return carDAO.deleteBuy(id);
    }

    @Override
    public boolean deleteNew(Object id) {
        return carDAO.deleteNew(id);
    }

    @Override
    public boolean deleteCar(Object id) {
        return carDAO.deleteCar(id);
    }
}
