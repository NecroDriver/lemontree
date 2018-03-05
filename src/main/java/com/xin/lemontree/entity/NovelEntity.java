package com.xin.lemontree.entity;

import com.xin.lemontree.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * @author creator 11934 2018/3/2 0002 17:07
 * @author updater 11934
 * @version 1.0.0
 * @description 小说eneity
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Component
@Table(name = "novel")
public class NovelEntity extends BaseEntity {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 小说编号
     */
    private String novelCode;

    /**
     * 小说名称
     */
    private String novelName;

    /**
     * url
     */
    private String url;

    /**
     * 封面图片
     */
    private String coverImg;

    /**
     * 是否更新,0:否 1:是
     */
    private Integer flagUpdate;

    /**
     * 是否完结,0:否 1:是
     */
    private Integer flagEnd;
}
