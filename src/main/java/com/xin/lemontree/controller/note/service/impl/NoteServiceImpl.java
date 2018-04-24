package com.xin.lemontree.controller.note.service.impl;

import com.xin.lemontree.common.base.BaseService;
import com.xin.lemontree.controller.note.service.INoteService;
import com.xin.lemontree.dao.note.LabelDao;
import com.xin.lemontree.dao.note.NoteDao;
import com.xin.lemontree.entity.note.LabelEntity;
import com.xin.lemontree.vo.UserLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author creator mafh 2018/4/24 16:04
 * @author updater mafh
 * @version 1.0.0
 * @description 笔记service实现类
 */
@Service
public class NoteServiceImpl extends BaseService implements INoteService {

    /**
     * 笔记dao
     */
    @Autowired
    private NoteDao noteDao;

    /**
     * 标签dao
     */
    @Autowired
    private LabelDao labelDao;

    /**
     * 添加标签
     *
     * @param request   请求
     * @param labelName 标签名称
     * @return 结果
     */
    @Override
    public Map<String, Object> saveLabelInfo(HttpServletRequest request, String labelName) {

        /*----------------------------------------------- 参数声明 --------------------------------------------------*/
        Map<String, Object> resultMap = new HashMap<>();
        UserLoginVo user = (UserLoginVo) request.getAttribute("user");
        Date nowDate = new Date();

        /*----------------------------------------------- 业务处理 --------------------------------------------------*/
        LabelEntity labelEntity = new LabelEntity();
        labelEntity.setLabelName(labelName);
        labelEntity.setCreateTime(nowDate);
        labelEntity.setCreator(user.getAccount());
        labelEntity.setCreatorIP(user.getIp());
        labelEntity.setModifyTime(nowDate);
        labelEntity.setModifier(user.getAccount());
        labelEntity.setModifierIP(user.getIp());
        labelDao.save(labelEntity);
        resultMap.put("insertId", labelEntity.getId());

        /*----------------------------------------------- 日志记录 --------------------------------------------------*/
        logger.debug("添加标签成功！" + resultMap);

        /*----------------------------------------------- 方法返回 --------------------------------------------------*/
        return resultMap;
    }
}
