/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: gaokao360
 * $Id:  AgentDAO.java 2015-12-15 17:52:12 $
 */
package cn.bwl.service;


import cn.bwl.domain.TestDomain;

import java.util.List;
import java.util.Map;

public interface ICarServcie {
    List<Map<String,Object>> bannerQueryList();
    List<Map<String,Object>> newsQueryList();
    List<Map<String,Object>> photosQueryList();
    List<Map<String,Object>> servicesQueryList();
    List<Map<String,Object>> newQueryPage(String orderBy,String sortBy,String offset,String rows);
    Integer newQueryCount();
    Map<String,Object> newQueryById(Object id);
    List<Map<String,Object>> carQueryPage(String orderBy,String sortBy,String offset,String rows, Map<String,Object> queryparam);
    Integer carQueryCount();
    Map<String,Object> carQueryById(Object id);
    List<Map<String,Object>> buyQueryPage(String orderBy,String sortBy,String offset,String rows);
    Integer buyQueryCount();
    Map<String,Object> buyQueryById(Object id);
    boolean login(Map<String,Object> map);

    boolean addBuy(Map<String,Object> map);
    boolean addNew(Map<String,Object> map);
    boolean addCar(Map<String,Object> map);

    boolean updateBuy(Map<String,Object> map);
    boolean updateNew(Map<String,Object> map);
    boolean updateCar(Map<String,Object> map);

    boolean deleteBuy(Object id);
    boolean deleteNew(Object id);
    boolean deleteCar(Object id);
}
