package com.xin.lemontree;

import org.springframework.util.DigestUtils;

public class LemontreeApplicationTests {

	public static void main(String[] args) {
//        UserLoginEntity userLoginEntity = new UserLoginEntity();
//        userLoginEntity.setId(1);
//        userLoginEntity.setAccount("nextTime");
//        userLoginEntity.setUserName("时光如墨");
//        userLoginEntity.setPassword("111111");
//        userLoginEntity.setSalt(UUID.randomUUID().toString());
//        userLoginEntity.setEncryptPassword("2222222");
//        userLoginEntity.setCreateTime(new Date());
//        userLoginEntity.setCreatorIP("localhost");
//        userLoginEntity.setModifyTime(new Date());
//        System.out.println(userLoginEntity);
////        UserLoginVo userLoginVo = new UserLoginVo();
////        BeanUtils.copyProperties(userLoginEntity, userLoginVo);
//        UserLoginVo userLoginVo = ConvertUtils.convert(userLoginEntity, UserLoginVo.class);
//        System.out.println(userLoginVo);
//        System.out.println(DigestUtils.md5DigestAsHex(("111").getBytes()));
//        System.out.println(DigestUtils.md5Digest(("111").getBytes()));
        sayHello(null);
	}

	public static void sayHello(Object object){
		System.out.println(object);
		System.out.println(object + "123");
    }
}
