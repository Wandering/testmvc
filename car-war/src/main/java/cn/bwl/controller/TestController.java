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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping(value="/test")
public class TestController{


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

}
