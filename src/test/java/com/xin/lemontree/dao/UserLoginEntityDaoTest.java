package com.xin.lemontree.dao;

import com.xin.lemontree.entity.UserLoginEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author creator mafh 2018/1/18 11:03
 * @author updater mafh
 * @version 1.0.0
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserLoginEntityDaoTest {

    @Autowired
    private UserLoginDao userLoginDao;

    @Test
    public void findByAccount() {
        UserLoginEntity userLoginEntity = userLoginDao.findByAccount("NecroDriver");
        System.out.println(userLoginEntity);
    }

    @Test
    public void findByEmailEndingWithAndCreateTimeLessThan() {
        Date date = new Date();
        List<UserLoginEntity> userLoginEntities = userLoginDao.findByEmailEndingWithAndCreateTimeLessThan("qq.com", date);
        System.out.println(userLoginEntities);
    }

    @Test
    public void getActiveUserCount() {
        long count = userLoginDao.getActiveUserCount("000", new Date());
        System.out.println(count);
    }

    @Test
    public void findByEmailAndPhoneLike() {
        List<UserLoginEntity> userLoginEntities = userLoginDao.findByEmailAndPhoneLike("qq.", "17");
        System.out.println(userLoginEntities);
    }

    @Test
    @Transactional
    public void updateEmail() {
        int num = userLoginDao.updateEmail("1193482868@qq.com", 0);
        System.out.println(num);
    }
}