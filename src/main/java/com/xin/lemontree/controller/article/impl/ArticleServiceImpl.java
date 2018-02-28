package com.xin.lemontree.controller.article.impl;

import com.xin.lemontree.controller.article.ArticleService;
import com.xin.lemontree.entity.ArticleEntity;

import java.util.List;

/**
 * @author creator mafh 2018/2/28 18:23
 * @author updater mafh
 * @version 1.0.0
 * @description 文章service实现
 */
public class ArticleServiceImpl implements ArticleService {
    /**
     * 根据期号获取文章列表
     *
     * @param stage 期号
     * @return 文章列表
     */
    @Override
    public List<ArticleEntity> getListForWeek(Integer stage) {
        return null;
    }
}
