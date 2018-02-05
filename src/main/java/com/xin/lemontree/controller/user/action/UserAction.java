package com.xin.lemontree.controller.user.action;

import com.xin.lemontree.controller.user.service.UserLoginService;
import com.xin.lemontree.entity.UserLoginEntity;
import com.xin.lemontree.vo.ResultVo;
import com.xin.lemontree.vo.UserLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultVo register(UserLoginEntity userLoginEntity) {
        return new ResultVo(true, userLoginEntity);
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
