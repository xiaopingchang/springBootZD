package com.zt.admin.controller;

import com.zt.admin.service.Demo1Service;
import com.zt.common.model.user.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gaoxuejian on 2018/12/26.
 */
@Controller
@RequestMapping("/page")
public class PageController {
    @Autowired
    private Demo1Service demo1Service;

    @RequestMapping("/index")
    public String pagetest(Model model, HttpServletRequest request){
        UserInfo userInfo = demo1Service.getUserInfo("1000000002");
        model.addAttribute("name",userInfo.getNickName());
        return "welcomepage";
    }
}
