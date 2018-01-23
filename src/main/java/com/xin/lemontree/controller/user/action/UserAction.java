package com.xin.lemontree.controller.user.action;

import com.xin.lemontree.entity.UserLoginEntity;
import com.xin.lemontree.vo.ResultVo;
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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultVo register(UserLoginEntity userLoginEntity){
        return new ResultVo(true, userLoginEntity);
    }
}
