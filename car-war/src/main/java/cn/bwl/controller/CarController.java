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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
//        Map<String,Object> map = new HashMap<>();
//        map.put("id",1);
//        map.put("name","牛车1");
//        map.put("price","100000"+"元");
//        map.put("img","images/temp/thumb-1.jpg");
//        map.put("content","<p>这是内容</p>");
//        map.put("RegNumbe","423423");
//        map.put("Mileage","20650");
//        map.put("BodyType","Sports");
//        map.put("ModelYear","2002");
//        map.put("EngineSize","3.8L");
//        map.put("Trans","Manual");
//        map.put("FuelType","Gas");
//        map.put("Specifications","<div class=\"five columns\">\n" +
//                "\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t\t<ul class=\"list type-1\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Body Style: </b><span>SEDAN 4-DR</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Driveline: </b><span>FWD</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Fuel Economy-city: </b><span>30-32 miles/gallon</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Anti-Brake System: </b><span>Non-ABS | 4-Wheel | ABS</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Brake Type: </b><span>Disc</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Turning Diameter: </b><span>36.10 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Rear Suspension: </b><span>Semi</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Rear Spring Type: </b><span>Coil</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Headroom: </b><span>39.10 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Legroom: </b><span>41.30 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Shoulder Room: </b><span>53.10 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Hip Room: </b><span>51.90 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Curb Weight-automatic: </b><span>2568 lbs</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Overall Length: </b><span>178.30 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t</ul>\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t</div>\n" +
//                "\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t<div class=\"five columns\">\n" +
//                "\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t\t<ul class=\"list type-1\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Overall Height: </b><span>58.50 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Ground Clearance: </b><span>5.70 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Track Front: </b><span>58.30 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Standard Seating: </b><span>5</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Cargo Volume: </b><span>13.60 ft.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Maximum Towing: </b><span>1500 lbs</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Basic-distance: </b><span>36.000 mile</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Engine Type: </b><span>1.8L L4 DOHC 16V</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t</ul>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t</div>");
//        map.put("Safety","<div class=\"five columns\">\n" +
//                "\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t\t<ul class=\"list type-1\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Fuel Economy-city: </b><span>30-32 miles/gallon</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Anti-Brake System: </b><span>Non-ABS | 4-Wheel | ABS</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Brake Type: </b><span>Disc</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Turning Diameter: </b><span>36.10 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Rear Suspension: </b><span>Semi</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t</ul>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t</div>\n" +
//                "\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t<div class=\"five columns\">\n" +
//                "\n" +
//                "\t\t\t\t\t\t\t\t\t\t<ul class=\"list type-1\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Overall Height: </b><span>58.50 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Ground Clearance: </b><span>5.70 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Track Front: </b><span>58.30 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Standard Seating: </b><span>5</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Cargo Volume: </b><span>13.60 ft.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Maximum Towing: </b><span>1500 lbs</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Basic-distance: </b><span>36.000 mile</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Engine Type: </b><span>1.8L L4 DOHC 16V</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t</ul>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t</div>");
//        map.put("Convenience","<div class=\"five columns\">\n" +
//                "\n" +
//                "\t\t\t\t\t\t\t\t\t\t<ul class=\"list type-1\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Body Style: </b><span>SEDAN 4-DR</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Driveline: </b><span>FWD</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Fuel Economy-city: </b><span>30-32 miles/gallon</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Anti-Brake System: </b><span>Non-ABS | 4-Wheel | ABS</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Rear Suspension: </b><span>Semi</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Rear Spring Type: </b><span>Coil</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Headroom: </b><span>39.10 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Legroom: </b><span>41.30 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Shoulder Room: </b><span>53.10 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Hip Room: </b><span>51.90 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Curb Weight-automatic: </b><span>2568 lbs</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t</ul>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t</div>\n" +
//                "\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t<div class=\"five columns\">\n" +
//                "\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t\t<ul class=\"list type-1\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Cargo Volume: </b><span>13.60 ft.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Maximum Towing: </b><span>1500 lbs</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Basic-distance: </b><span>36.000 mile</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Engine Type: </b><span>1.8L L4 DOHC 16V</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t</ul>\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t</div>");
//        map.put("Comfort","<ul class=\"list type-1\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Fuel Economy-city: </b><span>30-32 miles/gallon</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Anti-Brake System: </b><span>Non-ABS | 4-Wheel | ABS</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Brake Type: </b><span>Disc</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Turning Diameter: </b><span>36.10 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Rear Suspension: </b><span>Semi</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t</ul>\t");
//        map.put("Entertainment","<div class=\"five columns\">\n" +
//                "\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t\t<ul class=\"list type-1\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Body Style: </b><span>SEDAN 4-DR</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Driveline: </b><span>FWD</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Fuel Economy-city: </b><span>30-32 miles/gallon</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Anti-Brake System: </b><span>Non-ABS | 4-Wheel | ABS</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Rear Spring Type: </b><span>Coil</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Headroom: </b><span>39.10 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Legroom: </b><span>41.30 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Shoulder Room: </b><span>53.10 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Front Hip Room: </b><span>51.90 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Curb Weight-automatic: </b><span>2568 lbs</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t</ul>\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t</div>\n" +
//                "\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t<div class=\"five columns\">\n" +
//                "\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t\t<ul class=\"list type-1\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Track Front: </b><span>58.30 in.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Standard Seating: </b><span>5</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Cargo Volume: </b><span>13.60 ft.</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Maximum Towing: </b><span>1500 lbs</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Basic-distance: </b><span>36.000 mile</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<li><b>Engine Type: </b><span>1.8L L4 DOHC 16V</span></li>\n" +
//                "\t\t\t\t\t\t\t\t\t\t</ul>\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t\t\n" +
//                "\t\t\t\t\t\t\t\t\t</div>");
//        return map;
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
