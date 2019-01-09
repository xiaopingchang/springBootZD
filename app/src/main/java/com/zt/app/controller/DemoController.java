package com.zt.app.controller;

import com.alibaba.fastjson.JSON;
import com.zt.app.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gaoxuejian on 2018/12/25.
 */
@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/testget")
    public String testget(@RequestParam(name = "test",defaultValue = "1", required = true) String a){
        return "app userinfo " + JSON.toJSONString(demoService.getUserInfo("1000000002"));
    }
}
