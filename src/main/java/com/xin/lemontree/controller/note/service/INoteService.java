package com.xin.lemontree.controller.note.service;

import com.xin.lemontree.vo.note.LabelVo;

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
}
