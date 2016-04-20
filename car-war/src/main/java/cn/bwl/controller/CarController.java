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

import java.util.*;

@Controller
@RequestMapping(value="/car")
public class CarController {


    /**
     * 汽车主请求
     * @return
     */
    @RequestMapping(value="/carQueryPage")
    @ResponseBody
    public Object carQueryPage(){
        Map<String,Object> map = new HashMap<>();
        List list = new ArrayList();
        for(int i=0;i<6;i++){
            Map<String,Object> map1 = new HashMap<>();
            map1.put("name","牛车1");
            map1.put("price","100000"+"元");
            map1.put("img","images/sliders/slide-"+(i+1)+".jpg");
            list.add(map1);
        }
        map.put("list",list);
        return map;
    }


    /**
     * 新闻主请求
     * @return
     */
    @RequestMapping(value="/newQueryPage")
    @ResponseBody
    public Object newQueryPage(){
        Map<String,Object> map = new HashMap<>();
        List list = new ArrayList();
        for(int i=0;i<6;i++){
            Map<String,Object> map1 = new HashMap<>();
            map1.put("name","牛车1");
            map1.put("price","100000"+"元");
            map1.put("img","images/temp/thumb-1.jpg");
            list.add(map1);
        }
        map.put("list",list);
        return map;
    }


    /**
     * 添加客户留言
     * @return
     */
    @RequestMapping(value="/addCustomer")
    @ResponseBody
    public Object addCustomer(){
        Map<String,Object> map = new HashMap<>();
        List list = new ArrayList();
        for(int i=0;i<6;i++){
            Map<String,Object> map1 = new HashMap<>();
            map1.put("name","牛车1");
            map1.put("price","100000"+"元");
            map1.put("img","images/temp/thumb-1.jpg");
            list.add(map1);
        }
        map.put("list",list);
        return map;
    }
}
