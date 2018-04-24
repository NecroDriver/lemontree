package com.xin.lemontree.dao.note;

import com.xin.lemontree.entity.note.NoteEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author creator mafh 2018/4/24 16:10
 * @author updater mafh
 * @version 1.0.0
 * @description 笔记dao
 */
public interface NoteDao extends PagingAndSortingRepository<NoteEntity, Integer>, JpaSpecificationExecutor<NoteEntity> {
}
