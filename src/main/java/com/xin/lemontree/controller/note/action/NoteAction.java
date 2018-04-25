package com.xin.lemontree.controller.note.action;

import com.xin.lemontree.common.base.BaseAction;
import com.xin.lemontree.controller.note.service.INoteService;
import com.xin.lemontree.vo.ResultVo;
import com.xin.lemontree.vo.note.LabelVo;
import com.xin.lemontree.vo.note.NoteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author creator mafh 2018/4/24 15:40
 * @author updater mafh
 * @version 1.0.0
 * @description 笔记action
 */
@Controller
@RequestMapping("/api/note")
public class NoteAction extends BaseAction {

    /**
     * 笔记service
     */
    @Autowired
    private INoteService noteService;


    /**
     * 添加标签
     *
     * @param labelName 标签名称
     * @return 结果
     */
    @RequestMapping(value = "/saveLabelInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo saveLabelInfo(String labelName) {

        /*----------------------------------------------- 日志记录 --------------------------------------------------*/
        logger.debug("添加标签");

        /*----------------------------------------------- 参数校验 --------------------------------------------------*/
        validateNotEmpty(labelName, "标签名称不能为空！");

        /*----------------------------------------------- 业务处理 --------------------------------------------------*/
        Map<String, Object> resultMap = noteService.saveLabelInfo(request, labelName);

        /*----------------------------------------------- 方法返回 --------------------------------------------------*/
        return ResultVo.successVo(resultMap);
    }

    /**
     * 删除标签
     *
     * @param id 记录id
     * @return 结果
     */
    @RequestMapping(value = "/deleteLabel", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo deleteLabel(Integer id) {

        /*----------------------------------------------- 日志记录 --------------------------------------------------*/
        logger.debug("删除标签");

        /*----------------------------------------------- 参数校验 --------------------------------------------------*/
        validateInteger(id, "标签id不能为空！");

        /*----------------------------------------------- 业务处理 --------------------------------------------------*/
        Map<String, Object> resultMap = noteService.deleteLabel(request, id);

        /*----------------------------------------------- 方法返回 --------------------------------------------------*/
        return ResultVo.successVo(resultMap);
    }

    /**
     * 获取标签列表
     *
     * @return 列表
     */
    @RequestMapping(value = "/getLabelList", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo getLabelList() {

        /*----------------------------------------------- 日志记录 --------------------------------------------------*/
        logger.debug("获取标签列表");

        /*----------------------------------------------- 业务处理 --------------------------------------------------*/
        List<LabelVo> labelList = noteService.getLabelList();

        /*----------------------------------------------- 方法返回 --------------------------------------------------*/
        return ResultVo.successVo(labelList);
    }

    /**
     * 新增笔记
     *
     * @param title   标题
     * @param content 内容
     * @param labelId 标签id
     * @return 结果
     */
    @RequestMapping(value = "/saveNoteInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo saveNoteInfo(String title, String content, Integer labelId) {

        /*----------------------------------------------- 日志记录 --------------------------------------------------*/
        logger.debug("新增笔记");

        /*----------------------------------------------- 参数校验 --------------------------------------------------*/
        validateNotEmpty(title, "标题不能为空！");
        validateNotEmpty(content, "内容不能为空！");
        validateInteger(labelId, "关联标签不能为空！");

        /*----------------------------------------------- 业务处理 --------------------------------------------------*/
        Map<String, Object> resultMap = noteService.saveNoteInfo(request, title, content, labelId);

        /*----------------------------------------------- 方法返回 --------------------------------------------------*/
        return ResultVo.successVo(resultMap);
    }

    /**
     * 获取笔记列表
     *
     * @param keyword 关键字
     * @return 列表
     */
    @RequestMapping(value = "/getNotePage", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo getNotePage(String keyword) {

        /*----------------------------------------------- 日志记录 --------------------------------------------------*/
        logger.debug("获取笔记列表");

        /*----------------------------------------------- 业务处理 ----------------------------------------------*/
        List<NoteVo> noteList = noteService.getNotePage(request, keyword);

        /*----------------------------------------------- 方法返回 --------------------------------------------------*/
        return ResultVo.successVo(noteList);
    }
}