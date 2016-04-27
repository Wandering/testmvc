/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: gaokao360
 * $Id:  RoleUserController.java 2015-11-30 22:45:18 $
 */

package cn.bwl.controller;

import cn.bwl.service.ICarServcie;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.util.*;

@Controller
@RequestMapping(value="/input")
public class InputController {

    @Autowired
    private ICarServcie carServcie;

    /**
     * 汽车主请求
     * @return
     */
    @RequestMapping(value="/addBuy")
    @ResponseBody
    public Object addOrUpdateBuy(@RequestParam String carId,@RequestParam String name,@RequestParam String phone,@RequestParam String comments){
        try {
            Map<String,Object> map=new HashMap<>();
            map.put("carId",carId);
            map.put("name",name);
            map.put("phone",phone);
            map.put("message",comments);
            return carServcie.addBuy(map);
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 汽车主请求
     * @return
     */
    @RequestMapping(value="/addOrUpdateNew")
    @ResponseBody
    public Object addOrUpdateNew(@RequestParam String carId,@RequestParam String name,@RequestParam String phone,@RequestParam String comments){
        try {
            Map<String,Object> map=new HashMap<>();
            map.put("carId",carId);
            map.put("name",name);
            map.put("phone",phone);
            map.put("message",comments);
            return carServcie.addBuy(map);
        }catch (Exception e){
            return false;
        }
    }
}
