package com.xin.lemontree.controller.spider.service.impl;

import com.xin.lemontree.common.consts.SysConfig;
import com.xin.lemontree.controller.spider.service.NovelService;
import com.xin.lemontree.dao.NovelChapterDao;
import com.xin.lemontree.dao.NovelDao;
import com.xin.lemontree.entity.NovelChapterEntity;
import com.xin.lemontree.entity.NovelEntity;
import com.xin.lemontree.tools.jsoup.JsoupUtils;
import com.xin.lemontree.tools.jsoup.impl.NovelDocumentAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.*;

/**
 * @author creator 11934 2018/3/2 0002 15:25
 * @author updater 11934
 * @version 1.0.0
 * @description 小说文章service实现类
 */
@Service
@Transactional
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
     * 小说dao
     */
    @Autowired
    private NovelDao novelDao;

    /**
     * 获取小说列表
     *
     * @param novelCode 小说编号
     * @return 列表
     */
    @Override
    public List<Map<String, Object>> spiderNovelList(String novelCode) {

        List<Map<String, Object>> results = new ArrayList<>();
        try {
            List<NovelChapterEntity> novelChapterEntityList = JsoupUtils.getEntityList(SysConfig.NOVEL_BIQUGE_URL + novelCode, novelDocumentAnalyzer, NovelChapterEntity.class);
            novelChapterEntityList.forEach(novelChapterEntity -> {
                try {
                    Thread.sleep(500);
                    // 获取文章内容
                    Map<String, Object> contentMap = JsoupUtils.getMap(novelChapterEntity.getUrl(), novelDocumentAnalyzer);
                    novelChapterEntity.setContent(contentMap.get("content") + "");
                } catch (Exception e1) {
                    System.out.println("发生异常" + novelChapterEntity.getChapterName());
                }
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

    /**
     * 获取小说内容
     *
     * @param novelCode 小说编号
     * @return 列表
     */
    @Override
    public List<Map<String, Object>> spiderNovelContent(String novelCode) {

        List<Map<String, Object>> results = new ArrayList<>();
        novelChapterDao.findByNovelCodeEqualsAndContentIsNull(novelCode).forEach(novelChapterEntity -> {
            try {
                Thread.sleep(2000);
                Map<String, Object> result = JsoupUtils.getMap(novelChapterEntity.getUrl(), novelDocumentAnalyzer);
                novelChapterDao.updateContent(result.get("content") + "", novelChapterEntity.getId());
                result.put("name", novelChapterEntity.getChapterName());
                results.add(result);
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("发生异常！----" + novelChapterEntity.getChapterName());
            }
        });
        return results;
    }

    /**
     * 抓取更新小说
     *
     * @param novelCode 小说编号
     * @return 列表
     */
    @Override
    public List<NovelChapterEntity> spiderUpdatedNovelList(String novelCode) {

        List<NovelChapterEntity> results = new ArrayList<>();
        try {
            NovelChapterEntity newNovelChapterEntity = novelChapterDao.findTopByNovelCodeEqualsOrderByIdDesc(novelCode);
            Assert.notNull(newNovelChapterEntity, "未查询到最新章节！");
            List<NovelChapterEntity> novelChapterEntityList = JsoupUtils.getEntityList(SysConfig.NOVEL_BIQUGE_URL + novelCode, novelDocumentAnalyzer, NovelChapterEntity.class);
            for (int i = novelChapterEntityList.size() - 1; i >= 0; i--) {
                NovelChapterEntity novelChapterEntity = novelChapterEntityList.get(i);
                if (novelChapterEntity.getChapterName().equals(newNovelChapterEntity.getChapterName())) {
                    break;
                }
                Thread.sleep(500);
                // 获取文章内容
                Map<String, Object> contentMap = JsoupUtils.getMap(novelChapterEntity.getUrl(), novelDocumentAnalyzer);
                novelChapterEntity.setContent(contentMap.get("content") + "");
                novelChapterEntity.setNovelCode(novelCode);
                novelChapterEntity.setCreator("init");
                novelChapterEntity.setCreateTime(new Date());
                novelChapterEntity.setCreatorIP("127.0.0.1");
                novelChapterEntity.setModifier("init");
                novelChapterEntity.setModifyTime(new Date());
                novelChapterEntity.setModifierIP("127.0.0.1");
                results.add(novelChapterEntity);
            }
            Collections.reverse(results);
            novelChapterDao.save(results);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * 获取小说列表
     *
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param orderType 排序类型
     * @return 分页数据
     */
    @Override
    public Page<NovelEntity> getNovelPage(Integer pageNo, Integer pageSize, Integer orderType) {

        /*------------------------------------------- 参数声明 ------------------------------------------*/
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        PageRequest pageRequest = new PageRequest(pageNo, pageSize, sort);

        /*------------------------------------------- 方法返回 ------------------------------------------*/
        return novelDao.findAll(pageRequest);
    }
}
