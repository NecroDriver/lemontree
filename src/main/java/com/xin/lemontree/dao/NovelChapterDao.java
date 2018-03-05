package com.xin.lemontree.dao;

import com.xin.lemontree.entity.NovelChapterEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author creator 11934 2018/3/2 0002 18:54
 * @author updater 11934
 * @version 1.0.0
 * @description 小说章节dao
 */
public interface NovelChapterDao extends PagingAndSortingRepository<NovelChapterEntity, Integer>, JpaSpecificationExecutor<NovelChapterEntity> {
}
