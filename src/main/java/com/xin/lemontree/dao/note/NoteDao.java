package com.xin.lemontree.dao.note;

import com.xin.lemontree.entity.note.NoteEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * @author creator mafh 2018/4/24 16:10
 * @author updater mafh
 * @version 1.0.0
 * @description 笔记dao
 */
public interface NoteDao extends PagingAndSortingRepository<NoteEntity, Integer>, JpaSpecificationExecutor<NoteEntity> {

    /**
     * 根据id查询笔记信息
     *
     * @param id 笔记id
     * @return 数据
     */
    NoteEntity findByIdEquals(Integer id);

    /**
     * 更新flagUpdate标志
     *
     * @param id         笔记id
     * @param flagDelete 是否删除
     * @return 结果
     */
    @Modifying
    @Query("update NoteEntity set flagDelete = :flagDelete, modifyTime = :modifyTime, modifier = :modifier, modifierIP = :modifierIP where id = :id")
    int updateFlagDelete(@Param("id") Integer id, @Param("flagDelete") Integer flagDelete, @Param("modifyTime") Date modifyTime, @Param("modifier") String modifier, @Param("modifierIP") String modifierIP);
}
