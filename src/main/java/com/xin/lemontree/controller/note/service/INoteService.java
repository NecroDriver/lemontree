package com.xin.lemontree.controller.note.service;

import com.xin.lemontree.vo.note.LabelVo;
import com.xin.lemontree.vo.note.NoteVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author creator mafh 2018/4/24 16:03
 * @author updater mafh
 * @version 1.0.0
 * @description 笔记service
 */
public interface INoteService {

    /**
     * 添加标签
     *
     * @param request   请求
     * @param labelName 标签名称
     * @return 结果
     */
    Map<String, Object> saveLabelInfo(HttpServletRequest request, String labelName);

    /**
     * 删除标签
     *
     * @param request 请求
     * @param id      记录id
     * @return 结果
     */
    Map<String, Object> deleteLabel(HttpServletRequest request, Integer id);

    /**
     * 获取标签列表
     *
     * @return 列表
     */
    List<LabelVo> getLabelList();

    /**
     * 保存笔记
     *
     * @param request 请求
     * @param title   标题
     * @param content 内容
     * @param labelId 标签id
     * @return 结果
     */
    Map<String, Object> saveNoteInfo(HttpServletRequest request, String title, String content, Integer labelId);

    /**
     * 获取笔记列表
     *
     * @param request 请求
     * @param keyword 关键字
     * @return 列表
     */
    List<NoteVo> getNotePage(HttpServletRequest request, String keyword);
}
