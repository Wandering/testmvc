/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: gaokao360
 * $Id:  RoleUserController.java 2015-11-30 22:45:18 $
 */

package cn.bwl.controller;

import cn.bwl.domain.TestDomain;
import cn.bwl.service.ICarServcie;
import cn.bwl.service.ITestServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/info")
public class NewsInfoController {


    @Autowired
    private ICarServcie carServcie;
    /**
     * newInfo
     * @return
     */
    @RequestMapping(value="/newinfo")
    @ResponseBody
    public Object newinfo(@RequestParam Integer id){
        Map<String, Object> map = new HashMap<>();
        if(id==0) {
            map.put("imgUrl", "images/n3.jpg");
            map.put("title", "标题");
            map.put("content", "内容");
            map.put("subContent", "内容简介");
        }
        return map;
    }

    /**
     * photos
     * @return
     */
    @RequestMapping(value="/photos")
    @ResponseBody
    public Object photos(){
        List<Map<String,Object>> list=null;
        list=carServcie.photosQueryList();
        if(list==null || list.size()==0) {
            list = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("imgUrl", "images/" + (i + 4) + ".jpg");
                map.put("title", "标题" + i);
                map.put("content", "内容" + i);
                list.add(map);
            }
        }
        return list;
    }

}
