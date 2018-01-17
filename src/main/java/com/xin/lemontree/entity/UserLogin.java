package com.xin.lemontree.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author creator mafh 2018/1/17 17:35
 * @author updater mafh
 * @version 1.0.0
 * @description 用户登录实体类
 */
@Table(name = "user_login")
@Entity
@Data
public class UserLogin implements Serializable{

    /** 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer   id;
    /** 登录账号 */
    private String 	  account;
    /** 用户昵称 */
    private String 	  userName;
    /** 明文密码，不持久化到数据库 */
    @Transient
    private String 	  plainPassword;
    /** 加密后密码 */
    private String 	  password;
    /** 盐 */
    private String 	  salt;
    /** 手机号 */
    private String 	  phone;
    /** 邮箱 */
    private String 	  email;
    /** 平台 */
    private String 	  platform;
    /** 创建时间 */
    private Timestamp createTime;
    /** 创建人 */
    private String 	  creator;
    /** 创建人ip */
    private String 	  creatorIP;
    /** 修改时间 */
    private Timestamp modifyTime;
    /** 修改人 */
    private String 	  modifier;
    /** 修改人ip */
    private String 	  modifierIP;
}
