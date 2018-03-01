package com.xin.lemontree.common.consts;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author creator mafh 2018/1/18 18:08
 * @author updater mafh
 * @version 1.0.0
 * @description 系统配置文件读取
 */
public final class SysConfig {

    /**
     * redis key前缀
     */
    @Value("${redis.user_session_key}")
    public static String REDIS_USER_SESSION_KEY;
    /**
     * redis 有效时间
     */
    @Value("${redis.sso_session_expire}")
    public static Integer SSO_SESSION_EXPIRE;
    /**
     * cookieName
     */
    @Value("${cookie.name}")
    public static String COOKIE_NAME;

    /**
     * csdm settings
     */
    @Value("${csdn.weekly.preurl}")
    public static String CSDN_WEEKLY_PREURL;

//    static{
//        loadFromProp();
//    }
//
//    /**
//     * 读取配置文件信息
//     */
//    public static void loadFromProp(){
//        PropertiesUtils propertiesUtils = new PropertiesUtils("application.properties");
//        REDIS_USER_SESSION_KEY = propertiesUtils.getString("REDIS_USER_SESSION_KEY");
//        SSO_SESSION_EXPIRE = propertiesUtils.getInteger("SSO_SESSION_EXPIRE");
//        COOKIE_NAME = propertiesUtils.getString("COOKIE_NAME");
//        propertiesUtils.close();
//    }
}
