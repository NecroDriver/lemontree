package com.xin.lemontree.controller.user.action;

import com.xin.lemontree.controller.user.service.UserLoginService;
import com.xin.lemontree.vo.ResultVo;
import com.xin.lemontree.vo.UserLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author creator mafh 2018/1/17 17:17
 * @author updater mafh
 * @version 1.0.0
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserAction {

    /**
     * 用户登录service
     */
    @Autowired
    private UserLoginService userLoginService;

    private HttpServletRequest request;

    private HttpServletResponse response;

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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultVo register(String account, String userName, String password, String phone, String email) {
        Integer id = userLoginService.registerUser(account, userName, password, phone, email);
        return ResultVo.newResultVo(true, "注册成功！", id);
    }

    /**
     * 登录
     *
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultVo login(String account, String password) {
        UserLoginVo userLoginVo = userLoginService.login(account, password);
        return ResultVo.newResultVo(true, "登录成功！", userLoginVo);
    }

    /**
     * 登出
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "/loginout/{token}", method = RequestMethod.POST)
    public ResultVo loginout(@PathVariable("token") String token) {
        userLoginService.loginout(token);
        return ResultVo.newResultVo(true, "退出成功！", null);
    }

    /**
     * 获取用户
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "/user/{token}", method = RequestMethod.POST)
    public ResultVo getUser(String token) {
        UserLoginVo userLoginVo = userLoginService.queryUserByToken(token);
        return ResultVo.newResultVo(true, "成功获取用户信息！", userLoginVo);
    }
}
