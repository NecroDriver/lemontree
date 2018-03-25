package com.xin.lemontree.dao.novel;

import com.xin.lemontree.entity.novel.NovelEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author creator 11934 2018/3/13 0013 16:38
 * @author updater 11934
 * @version 1.0.0
 * @description 小说dao
 */
public interface NovelDao extends PagingAndSortingRepository<NovelEntity, Integer>,JpaSpecificationExecutor<NovelEntity> {
}
