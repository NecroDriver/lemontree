package com.xin.lemontree;

import com.xin.lemontree.entity.UserLoginEntity;
import com.xin.lemontree.tools.Convert.ConvertUtils;
import com.xin.lemontree.vo.UserLoginVo;

import java.util.Date;
import java.util.UUID;

public class LemontreeApplicationTests {

	public static void main(String[] args) {
        UserLoginEntity userLoginEntity = new UserLoginEntity();
        userLoginEntity.setId(1);
        userLoginEntity.setAccount("nextTime");
        userLoginEntity.setUserName("时光如墨");
        userLoginEntity.setPassword("111111");
        userLoginEntity.setSalt(UUID.randomUUID().toString());
        userLoginEntity.setEncryptPassword("2222222");
        userLoginEntity.setCreateTime(new Date());
        userLoginEntity.setCreatorIP("localhost");
        userLoginEntity.setModifyTime(new Date());
        System.out.println(userLoginEntity);
//        UserLoginVo userLoginVo = new UserLoginVo();
//        BeanUtils.copyProperties(userLoginEntity, userLoginVo);
        UserLoginVo userLoginVo = ConvertUtils.convert(userLoginEntity, UserLoginVo.class);
        System.out.println(userLoginVo);
	}

	public static void sayHello(){
	    System.out.println("123");
    }
}
