package com.xin.lemontree.controller.novel.service;

import com.xin.lemontree.entity.novel.NovelChapterEntity;
import com.xin.lemontree.vo.novel.NovelChapterVo;
import com.xin.lemontree.vo.novel.NovelVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @author creator 11934 2018/3/2 0002 15:03
 * @author updater 11934
 * @version 1.0.0
 * @description 小说service
 */
public interface NovelService {

    /**
     * 获取小说列表
     *
     * @param NovelCode 小说编号
     * @return 列表
     */
    List<Map<String, Object>> spiderNovelList(String NovelCode);

    /**
     * 获取小说内容
     *
     * @param novelCode 小说编号
     * @return 列表
     */
    List<Map<String, Object>> spiderNovelContent(String novelCode);

    /**
     * 抓取更新小说
     *
     * @param novelCode 小说编号
     * @return 列表
     */
    List<NovelChapterEntity> spiderUpdatedNovelList(String novelCode);

    /**
     * 获取小说列表
     *
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param orderType 排序类型
     * @return 分页数据
     */
    Page<NovelVo> getNovelPage(Integer pageNo, Integer pageSize, Integer orderType);

    /**
     * 获取小说章节列表
     *
     * @param novelCode 小说编号
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param orderType 排序类型
     * @return 分页数据
     */
    Page<NovelChapterVo> getNovelChapterPage(String novelCode, Integer pageNo, Integer pageSize, Integer orderType);

    /**
     * 获取所有小说列表
     *
     * @return 列表
     */
    List<NovelVo> getNovelList();

    /**
     * 获取小说章节
     *
     * @param id id
     * @return 信息
     */
    NovelChapterVo getNovelChapter(Integer id);
}
