package com.xin.lemontree.dao;

import com.xin.lemontree.LemontreeApplication;
import com.xin.lemontree.entity.NovelChapterEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author creator 11934 2018/3/5 0005 14:03
 * @author updater 11934
 * @version 1.0.0
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NovelChapterDaoTest {

    /**
     * 章节dao
     */
    @Autowired
    private NovelChapterDao novelChapterDao;

    @Test
    public void findByContentIsNull() {
        List<NovelChapterEntity> novelChapterEntityList = novelChapterDao.findByNovelCodeEqualsAndContentIsNull("40_40183");
        System.out.println(novelChapterEntityList);
    }
}