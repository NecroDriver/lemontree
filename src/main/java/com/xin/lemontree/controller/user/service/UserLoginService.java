package com.xin.lemontree.controller.user.service;

import com.xin.lemontree.vo.UserLoginVo;

/**
 * @author creator mafh 2018/1/18 14:40
 * @author updater mafh
 * @version 1.0.0
 * @description 用户登录service
 */
public interface UserLoginService {

    /**
     * 注册用户
     *
     * @param account
     * @param userName
     * @param password
     * @param phone
     * @param email
     * @return 结果
     */
    Integer registerUser(String account, String userName, String password, String phone, String email);

    /**
     * 用户登录
     *
     * @param account  账户
     * @param password 密码
     * @return 数据
     */
    UserLoginVo login(String account, String password);

    /**
     * 登出
     *
     * @param token 口令
     */
    void loginout(String token);

    /**
     * 根据口令获取用户信息
     *
     * @param token
     * @return 数据
     */
    UserLoginVo queryUserByToken(String token);
}
