package com.xin.lemontree.vo.note;

import com.xin.lemontree.common.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author creator mafh 2018/4/24 15:32
 * @author updater mafh
 * @version 1.0.0
 * @description 笔记实体
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class NoteVo extends BaseVo {

    /**
     * 主键
     */
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
