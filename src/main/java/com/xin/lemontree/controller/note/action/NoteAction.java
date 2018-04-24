package com.xin.lemontree.controller.note.action;

import com.xin.lemontree.common.base.BaseAction;
import com.xin.lemontree.controller.note.service.INoteService;
import com.xin.lemontree.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value = "/saveLabelInfo",method = RequestMethod.POST)
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
}
