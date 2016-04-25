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
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping(value="/car")
public class CarController {


    @Autowired
    private ICarServcie carServcie;
    /**
     * 汽车主请求
     * @return
     */
    @RequestMapping(value="/carQueryPage")
    @ResponseBody
    public Object carQueryPage(@RequestParam Integer page,@RequestParam Integer rows){
        List list=carServcie.carQueryPage("id", "desc", (page-1)*rows+"",rows+"");
        Integer count=carServcie.carQueryCount();
        Integer pages=1;
        try{
            pages=count/rows+1;
        }catch (Exception e){

        }
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        map.put("currPage",page);
        map.put("pages",pages);
        map.put("count", count);

//        Map<String,Object> map = new HashMap<>();
//        List list = new ArrayList();
//        for(int i=0;i<6;i++){
//            Map<String,Object> map1 = new HashMap<>();
//            map1.put("id",i);
//            map1.put("name","牛车1"+page);
//            map1.put("price","100000"+"元");
//            map1.put("img","images/sliders/slide-"+(i+1)+".jpg");
//            list.add(map1);
//        }
//        map.put("list",list);
//        map.put("currPage",page);
//        map.put("pages",3);
//        map.put("count",18);
        return map;
    }

    /**
     * 汽车主请求
     * @return
     */
    @RequestMapping(value="/carQueryOne")
    @ResponseBody
    public Object carQueryOne(@RequestParam Integer id){
        return carServcie.carQueryById(id);
    }

    /**
     * 新闻主请求
     * @return
     */
    @RequestMapping(value="/newQueryPage")
    @ResponseBody
    public Object newQueryPage(@RequestParam Integer page,@RequestParam Integer rows){
        List list=carServcie.newQueryPage("id", "desc", (page-1)*rows+"",rows+"");
        Integer count=carServcie.newQueryCount();
        Integer pages=1;
        try{
            pages=count/rows+1;
        }catch (Exception e){

        }
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        map.put("currPage",page);
        map.put("pages",pages);
        map.put("count",count);
        return map;
    }
    /**
     * 汽车主请求
     * @return
     */
    @RequestMapping(value="/newQueryOne")
    @ResponseBody
    public Object newQueryOne(@RequestParam Integer id){
        return carServcie.newQueryById(id);
    }

    /**
     * 订单主请求
     * @return
     */
    @RequestMapping(value="/buyQueryPage")
    @ResponseBody
    public Object buyQueryPage(@RequestParam Integer page,@RequestParam Integer rows){
        List list=carServcie.buyQueryPage("id", "desc", (page - 1) * rows + "", rows + "");
        Integer count=carServcie.buyQueryCount();
        Integer pages=1;
        try{
            pages=count/rows+1;
        }catch (Exception e){

        }
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        map.put("currPage",page);
        map.put("pages",pages);
        map.put("count",count);
        return map;
    }
    /**
     * 汽车主请求
     * @return
     */
    @RequestMapping(value="/buyQueryOne")
    @ResponseBody
    public Object buyQueryOne(@RequestParam Integer id){
        return carServcie.buyQueryById(id);
    }

    /**
     * 汽车主请求
     * @return
     */
    @RequestMapping(value="/login")
    @ResponseBody
    public Object buyQueryOne(@RequestParam String username,@RequestParam String pwd,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("pwd",pwd);
        if(carServcie.login(map)) {
            Cookie cookie = new Cookie("username", username);

            cookie.setMaxAge(36000);

//设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问

            cookie.setPath("/");
            response.addCookie(cookie);
            return true;
        }
        return false;
    }
}
