package com.xin.lemontree.controller.spider.service;

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
     * @param NovelCode
     * @return
     */
    List<Map<String, Object>> getNovelList(String NovelCode);
}
