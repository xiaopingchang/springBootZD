package com.zt.admin.controller;

import com.alibaba.fastjson.JSON;
import com.zt.admin.service.Demo1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gaoxuejian on 2018/12/25.
 */
@RestController
public class Demo1Controller {
    @Autowired
    private Demo1Service demo1Service;
    @RequestMapping("/testget")
    public String testadmin(@RequestParam(name = "test",defaultValue = "1", required = true) String a){
        return "admin" + JSON.toJSONString(demo1Service.getUserInfo("1000000002"));
    }
}
