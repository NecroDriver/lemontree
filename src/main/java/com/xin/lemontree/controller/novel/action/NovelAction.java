package com.xin.lemontree.controller.novel.action;

import com.xin.lemontree.common.base.BaseAction;
import com.xin.lemontree.controller.novel.service.NovelService;
import com.xin.lemontree.vo.ResultVo;
import com.xin.lemontree.vo.novel.NovelChapterVo;
import com.xin.lemontree.vo.novel.NovelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

        /*-------------------------------------------- 日志记录 ------------------------------------------------------*/
        logger.debug("获取小说分页");

        /*-------------------------------------------- 参数校验 ------------------------------------------------------*/
        validateInteger(orderType, "排序方式");
        if (ObjectUtils.isEmpty(pageNo)) {
            pageNo = 1;
        }
        if (ObjectUtils.isEmpty(pageSize)) {
            pageSize = 10;
        }

        /*-------------------------------------------- 业务处理 ------------------------------------------------------*/
        Page<NovelVo> novelVoPage = novelService.getNovelPage(pageNo, pageSize, orderType);

        /*-------------------------------------------- 方法返回 ------------------------------------------------------*/
        return ResultVo.newResultVo(true, "获取小说分页成功！", novelVoPage);
    }

    /**
     * 获取小说章节列表
     *
     * @param novelCode 小说编号
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param orderType 排序类型
     * @return 分页数据
     */
    @RequestMapping(value = "/{novelCode}/page/{pageNo}", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo getNovelChapterPage(@PathVariable("novelCode") String novelCode, @PathVariable("pageNo") Integer pageNo, Integer pageSize, Integer orderType) {

        /*-------------------------------------------- 日志记录 ------------------------------------------------------*/
        logger.debug("获取小说章节列表");

        /*-------------------------------------------- 参数校验 ------------------------------------------------------*/
        validateNotEmpty(novelCode, "小说编号");
        validateInteger(orderType, "排序方式");
        if (ObjectUtils.isEmpty(pageNo)) {
            pageNo = 1;
        }
        if (ObjectUtils.isEmpty(pageSize)) {
            pageSize = 25;
        }

        /*-------------------------------------------- 业务处理 ------------------------------------------------------*/
        Page<NovelChapterVo> novelChapterVoPage = novelService.getNovelChapterPage(novelCode, pageNo, pageSize, orderType);

        /*-------------------------------------------- 方法返回 ------------------------------------------------------*/
        return ResultVo.successVo(novelChapterVoPage);
    }

    /**
     * 获取所有小说列表
     *
     * @return 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo getNovelList() {

        /*-------------------------------------------- 日志记录 ------------------------------------------------------*/
        logger.debug("获取小说列表");

        /*-------------------------------------------- 业务处理 ------------------------------------------------------*/
        List<NovelVo> novelVoList = novelService.getNovelList();

        /*-------------------------------------------- 方法返回 ------------------------------------------------------*/
        return ResultVo.newResultVo(true, "获取小说列表成功！", novelVoList);
    }
}
