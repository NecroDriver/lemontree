package com.xin.lemontree.controller.spider.action;

import com.xin.lemontree.common.base.BaseAction;
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
public class NovelAction extends BaseAction {

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
    @RequestMapping(value = "/spider/list/{novelCode}", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo spiderNovelList(@PathVariable("novelCode") String novelCode) {
        return ResultVo.newResultVo(true, "获取小说列表成功！", novelService.spiderNovelList(novelCode));
    }

    /**
     * 获取小说内容
     *
     * @param novelCode 小说编号
     * @return 列表
     */
    @RequestMapping(value = "/spider/content/{novelCode}", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo spiderNovelContent(@PathVariable("novelCode") String novelCode) {
        return ResultVo.newResultVo(true, "获取小说内容成功！", novelService.spiderNovelContent(novelCode));
    }

    /**
     * 获取小数更新章节
     *
     * @param novelCode 小说编号
     * @return 列表
     */
    @RequestMapping(value = "/spider/updated/{novelCode}", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo spiderUpdatedNovelList(@PathVariable("novelCode") String novelCode) {
        return ResultVo.newResultVo(true, "获取更新章节成功！", novelService.spiderUpdatedNovelList(novelCode));
    }

    /**
     * 获取小说分页
     *
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param orderType 排序类型
     * @return 分页数据
     */
    @RequestMapping(value = "/page/{pageNo}", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo getNovelPage(@PathVariable("pageNo") Integer pageNo, Integer pageSize, Integer orderType) {
        return ResultVo.newResultVo(true, "获取小说分页成功！", novelService.getNovelPage(pageNo, pageSize, orderType));
    }
}
