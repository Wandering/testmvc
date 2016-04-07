/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: gaokao360
 * $Id:  RoleUserController.java 2015-11-30 22:45:18 $
 */

package cn.bwl.controller;

import cn.bwl.domain.TestDomain;
import cn.bwl.service.ITestServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/index")
public class IndexController {


    @Autowired
    private ITestServcie testServcie;


    /**
     * 测试连接请求
     * @return
     */
    @RequestMapping(value="/test")
    @ResponseBody
    public List<TestDomain> queryList(){
        Map<String,Object> map = new HashMap<>();
        return testServcie.queryList(map);
    }

    /**
     * banner
     * @return
     */
    @RequestMapping(value="/banner")
    @ResponseBody
    public Object banner(){
        List<Map<String,Object>> list= new ArrayList<>();
        for(int i = 0 ; i<5;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("title", "标题"+i);
            map.put("content", "内容"+i);
            list.add(map);
        }

        return list;
    }

    /**
     * services
     * @return
     */
    @RequestMapping(value="/services")
    @ResponseBody
    public Object services(){
        List<Map<String,Object>> list= new ArrayList<>();
        for(int i = 0 ; i<4;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("imgUrl", "images/"+(i+7)+".jpg");
            map.put("title", "标题"+i);
            map.put("content", "内容"+i);
            list.add(map);
        }

        return list;
    }

    /**
     * services
     * @return
     */
    @RequestMapping(value="/news")
    @ResponseBody
    public Object news(){
        List<Map<String,Object>> list= new ArrayList<>();
        for(int i = 0 ; i<4;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("imgUrl", "images/n"+(i+1)+".jpg");
            map.put("title", "标题"+i);
            map.put("content", "内容"+i);
            map.put("subContent", "内容简介"+i);
            map.put("url", "single.html");
            list.add(map);
        }
        return list;
    }
}
