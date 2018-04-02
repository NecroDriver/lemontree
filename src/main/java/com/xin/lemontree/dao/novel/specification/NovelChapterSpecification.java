package com.xin.lemontree.dao.novel.specification;

import com.xin.lemontree.entity.novel.NovelChapterEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;

/**
 * @author creator 11934 2018/3/29 0029 10:15
 * @author updater 11934
 * @version 1.0.0
 * @description
 */
public class NovelChapterSpecification {

    public static Specification<NovelChapterEntity> selectByNovleCode(String novelCode) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Path<String> novelCodePath = root.get("novelCode");
            return criteriaBuilder.equal(novelCodePath, novelCode);
        };
    }
}
