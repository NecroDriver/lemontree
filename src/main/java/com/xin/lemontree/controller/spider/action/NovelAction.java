package com.xin.lemontree.controller.spider.action;

import com.xin.lemontree.controller.spider.service.NovelService;
import com.xin.lemontree.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author creator 11934 2018/3/2 0002 15:33
 * @author updater 11934
 * @version 1.0.0
 * @description 小说action
 */
@Controller
@RequestMapping("/novel")
public class NovelAction {

    /**
     * 小说service
     */
    @Autowired
    private NovelService novelService;

    /**
     * 获取小说列表
     *
     * @param novelCode 小说编号
     * @return 列表
     */
    @RequestMapping(value = "/list/{novelCode}", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo getNovelList(@PathVariable("novelCode") String novelCode) {
        return ResultVo.newResultVo(true, "获取小说列表成功！", novelService.getNovelList(novelCode));
    }
}
