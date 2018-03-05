package com.xin.lemontree.controller.spider.service.impl;

import com.xin.lemontree.common.consts.SysConfig;
import com.xin.lemontree.controller.spider.service.NovelService;
import com.xin.lemontree.dao.NovelChapterDao;
import com.xin.lemontree.entity.NovelChapterEntity;
import com.xin.lemontree.tools.jsoup.JsoupUtils;
import com.xin.lemontree.tools.jsoup.impl.NovelDocumentAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author creator 11934 2018/3/2 0002 15:25
 * @author updater 11934
 * @version 1.0.0
 * @description 小说文章service实现类
 */
@Service
public class NovelServiceImpl implements NovelService {

    /**
     * 小说解析器
     */
    @Autowired
    private NovelDocumentAnalyzer novelDocumentAnalyzer;

    /**
     * 小说章节dao
     */
    @Autowired
    private NovelChapterDao novelChapterDao;

    /**
     * 获取小说列表
     *
     * @param novelCode
     * @return
     */
    @Override
    public List<Map<String, Object>> getNovelList(String novelCode) {

        List<Map<String, Object>> results = new ArrayList<>();
        try {
            List<NovelChapterEntity> novelChapterEntityList = JsoupUtils.getEntityList(SysConfig.NOVEL_BIQUGE_URL + novelCode, novelDocumentAnalyzer, NovelChapterEntity.class);
            novelChapterEntityList.forEach(novelChapterEntity -> {
                novelChapterEntity.setNovelCode(novelCode);
                novelChapterEntity.setCreator("init");
                novelChapterEntity.setCreateTime(new Date());
                novelChapterEntity.setCreatorIP("127.0.0.1");
                novelChapterEntity.setModifier("init");
                novelChapterEntity.setModifyTime(new Date());
                novelChapterEntity.setModifierIP("127.0.0.1");
            });
            novelChapterDao.save(novelChapterEntityList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
