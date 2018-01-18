package com.xin.lemontree.controller.user.service.impl;

import com.xin.lemontree.controller.user.service.UserLoginService;
import com.xin.lemontree.dao.UserLoginDao;
import com.xin.lemontree.entity.UserLoginEntity;
import com.xin.lemontree.tools.json.JsonUtils;
import com.xin.lemontree.vo.UserLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author creator mafh 2018/1/18 15:50
 * @author updater mafh
 * @version 1.0.0
 * @description
 */
public class UserLoginServiceImpl implements UserLoginService {

    /** 用户登录dao */
    @Autowired
    private UserLoginDao userLoginDao;
    /** redis模板 */
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 注册用户
     *
     * @param account  账户
     * @param userName 昵称
     * @param password 密码
     * @param salt     盐
     * @param email    邮箱
     * @param phone    手机
     * @param platform 平台
     * @return 结果
     */
    @Override
    public Integer registerUser(String account, String userName, String password, String salt, String email, String phone, String platform) {
        return null;
    }

    /**
     * 用户登录
     *
     * @param account  账户
     * @param password 密码
     * @return 数据
     */
    @Override
    public UserLoginVo login(String account, String password) {
        UserLoginEntity userLoginEntity = userLoginDao.findByAccount(account);
        String encryptPassword = DigestUtils.md5DigestAsHex((password + userLoginEntity.getSalt()).getBytes());
        // 判断账号密码是否正确
        if(!userLoginEntity.getEncryptPassword().equals(encryptPassword)){
            Assert.isNull(null,"账号名或密码错误");
        }
        // 生成token
        String token = UUID.randomUUID().toString();
        // 清空密码和盐避免泄露
        userLoginEntity.setEncryptPassword(null);
        userLoginEntity.setSalt(null);
        // 把用户信息写入redis
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("USER" + token, JsonUtils.objectToJson(userLoginEntity), 30);
        //
        return null;
    }

    /**
     * 登出
     *
     * @param token 口令
     * @return 结果
     */
    @Override
    public Integer loginout(String token) {
        return null;
    }

    /**
     * 根据口令获取用户信息
     *
     * @param token
     * @return 数据
     */
    @Override
    public UserLoginVo queryUserByToken(String token) {
        return null;
    }
}
