package com.xin.lemontree.controller.user.service.impl;

import com.xin.lemontree.common.SysConfig;
import com.xin.lemontree.controller.user.service.UserLoginService;
import com.xin.lemontree.dao.UserLoginDao;
import com.xin.lemontree.entity.UserLoginEntity;
import com.xin.lemontree.tools.Convert.ConvertUtils;
import com.xin.lemontree.tools.json.JsonUtils;
import com.xin.lemontree.vo.UserLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

import javax.transaction.Transactional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author creator mafh 2018/1/18 15:50
 * @author updater mafh
 * @version 1.0.0
 * @description
 */
@Service
@Transactional
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
        String salt = userLoginEntity.getSalt();
        String encryptPassword = DigestUtils.md5DigestAsHex((password + salt).getBytes());
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
        operations.set(SysConfig.REDIS_USER_SESSION_KEY + token, JsonUtils.objectToJson(userLoginEntity));
        // 设置过期时间
        operations.getOperations().expire(SysConfig.REDIS_USER_SESSION_KEY + token, SysConfig.SSO_SESSION_EXPIRE, TimeUnit.SECONDS);
        // 添加写 cookie 的逻辑，cookie 的有效期是关闭浏览器就失效。
        // TODO

        // 将entity转成vo
        UserLoginVo userLoginVo =  ConvertUtils.convert(userLoginEntity, UserLoginVo.class);
        // user 已经是持久化对象了，被保存在了session缓存当中，若user又重新修改了属性值，那么在提交事务时，此时 hibernate对象就会拿当前这个user对象和保存在session缓存中的user对象进行比较，如果两个对象相同，则不会发送update语句，否则，如果两个对象不同，则会发出update语句。
        userLoginEntity.setEncryptPassword(encryptPassword);
        userLoginEntity.setSalt(salt);
        // 将token放置于userLoginVo中
        userLoginVo.setToken(token);

        /********************************************************* 结果返回 ************************************************************/
        return userLoginVo;
    }

    /**
     * 登出
     *
     * @param token 口令
     */
    @Override
    public void loginout(String token) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.getOperations().delete(SysConfig.REDIS_USER_SESSION_KEY + token);
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
