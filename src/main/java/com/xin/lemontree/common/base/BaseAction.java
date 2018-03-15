package com.xin.lemontree.common.base;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author creator 11934 2018/3/13 0013 17:04
 * @author updater 11934
 * @version 1.0.0
 * @description 基础action，用于存放一些基础数据
 */
public class BaseAction {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    /**
     * 说明：ModelAttribute的作用
     * 1)放置在形参上，表示引用model中的数据
     * 2）放置在方法上面：表示请求该类的每个Action前都会首先执行它，也可以将一些准备数据的操作放置在该方法里面。
     *
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
}
