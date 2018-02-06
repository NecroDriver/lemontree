package com.xin.lemontree.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author creator mafh 2017/12/18 13:53
 * @author updater mafh
 * @version 1.0.0
 * @description
 */
@Controller
public class HelloController {

    /**
     * 初始化登录页面
     *
     * @return 视图
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 主视图
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
