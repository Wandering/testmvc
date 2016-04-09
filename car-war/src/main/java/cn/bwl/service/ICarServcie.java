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
}
