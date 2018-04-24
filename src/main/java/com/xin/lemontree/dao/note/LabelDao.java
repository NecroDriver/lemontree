package com.xin.lemontree.dao.note;

import com.xin.lemontree.entity.note.LabelEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author creator mafh 2018/4/24 16:13
 * @author updater mafh
 * @version 1.0.0
 * @description 标签dao
 */
public interface LabelDao extends PagingAndSortingRepository<LabelEntity, Integer>, JpaSpecificationExecutor<LabelEntity> {
}
