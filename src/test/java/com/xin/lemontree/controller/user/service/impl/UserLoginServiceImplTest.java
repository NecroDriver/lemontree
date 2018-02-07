package com.xin.lemontree.controller.user.service.impl;

import com.xin.lemontree.controller.user.service.UserLoginService;
import com.xin.lemontree.vo.UserLoginVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author creator mafh 2018/1/19 14:40
 * @author updater mafh
 * @version 1.0.0
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserLoginServiceImplTest {

    @Autowired
    private UserLoginService userLoginService;

    @Test
    public void registerUser() {
    }

    @Test
    public void login() {
//        UserLoginVo userLoginVo = userLoginService.login("NecroDriver","1111111");
//        System.out.println(userLoginVo);
    }

    @Test
    public void loginout() {
        String token = "afb63d57-f6ee-4df9-913a-e6282813149a";
        userLoginService.loginout(token);
    }

    @Test
    public void queryUserByToken() {
        String token = "afb63d57-f6ee-4df9-913a-e6282813149a";
        UserLoginVo userLoginVo = userLoginService.queryUserByToken(token);
        System.out.println(userLoginVo);
    }
}