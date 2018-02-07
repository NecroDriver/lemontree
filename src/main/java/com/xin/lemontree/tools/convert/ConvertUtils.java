package com.xin.lemontree.tools.convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * @author creator mafh 2018/1/19 14:27
 * @author updater mafh
 * @version 1.0.0
 * @description 转化工具类
 */
public class ConvertUtils {

    /** 资源类 */
    private static Logger logger = LoggerFactory.getLogger(ConvertUtils.class);

    /**
     * 将对象转换成想要的目标对象
     *
     * @param sourceObject 资源对象
     * @param targetClass 目标类
     * @param <T> 泛型
     * @return 目标对象
     */
    public static <T>T convert(Object sourceObject, Class<T> targetClass){
        try {
            T targetObject = targetClass.newInstance();
            BeanUtils.copyProperties(sourceObject, targetObject);
            return targetObject;
        } catch (Exception e) {
            logger.error("转换失败", e);
        }
        return null;
    }
}
