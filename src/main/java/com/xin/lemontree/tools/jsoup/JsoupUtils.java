package com.xin.lemontree.tools.jsoup;

import com.xin.lemontree.tools.convert.ConvertUtils;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author creator mafh 2018/3/1 10:20
 * @author updater mafh
 * @version 1.0.0
 * @description
 */
public class JsoupUtils {

    /**
     * 日志工具
     */
    private static final Logger logger = LoggerFactory.getLogger(JsoupUtils.class);

    public static <T> List<T> getEntityList(String url, DocumentAnalyzer documentAnalyzer, Class<T> clazz) throws Exception {
        /**------------------------------------------日志记录-------------------------------------------**/
        logger.debug("开始抓取数据：" + url);
        /**------------------------------------------参数声明-------------------------------------------**/
        List<T> results = new ArrayList<>();
        /**------------------------------------------业务处理-------------------------------------------**/
        documentAnalyzer.getMapList(Jsoup.connect(url).timeout(5000).get()).forEach(map -> {
            try {
                T entity = ConvertUtils.convertMapToBean(map, clazz);
                results.add(entity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        /**------------------------------------------方法返回-------------------------------------------**/
        return results;
    }
}
