package com.xin.lemontree.entity.note;

import com.xin.lemontree.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author creator mafh 2018/4/24 15:32
 * @author updater mafh
 * @version 1.0.0
 * @description 笔记实体
 */
@SuppressWarnings(value = "serial")
@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@Table(name = "note")
public class NoteEntity extends BaseEntity implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 标签id
     */
    private String labelId;

}
