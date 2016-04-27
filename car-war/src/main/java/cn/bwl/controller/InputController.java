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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
    public Object addOrUpdateNew(@RequestParam String newDate,@RequestParam String type){
        try {
            Map<String,Object> map=(Map<String,Object> )JSON.parse(newDate);
            if("add".equals(type)){
                carServcie.addNew(map);
            }else if("update".equals(type)){

            }
//            map.put("title",title);
//            map.put("content",content);
//            map.put("subinfo",subinfo);
//            map.put("date",date);
//            map.put("img",img);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    /**
     * 汽车主请求
     * @return
     */
    @RequestMapping(value="/deleteNew")
    @ResponseBody
    public Object deleteNew(@RequestParam String id){
        try {
            return carServcie.deleteNew(id);
        }catch (Exception e){
            return false;
        }
    }
    /**
     * 汽车主请求
     * @return
     */
    @RequestMapping(value="/imgUpload")
    @ResponseBody
    public Object imgUpload(@RequestParam MultipartFile file,HttpServletRequest request){
        String path =request.getSession().getServletContext().getRealPath("/images/upload/");
        String fileName = file.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/images/upload/"+targetFile.getName();
    }

    /**
     * 汽车主请求
     * @return
     */
    @RequestMapping(value="/addOrUpdateCar")
    @ResponseBody
    public Object addOrUpdateCar(@RequestParam String carDate,@RequestParam String type){
        try {
            Map<String,Object> map=(Map<String,Object> )JSON.parse(carDate);
            if("add".equals(type)){
                carServcie.addCar(map);
            }else if("update".equals(type)){

            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
    /**
     * 汽车主请求
     * @return
     */
    @RequestMapping(value="/deleteCar")
    @ResponseBody
    public Object deleteCar(@RequestParam String id){
        try {
            return carServcie.deleteCar(id);
        }catch (Exception e){
            return false;
        }
    }
}
