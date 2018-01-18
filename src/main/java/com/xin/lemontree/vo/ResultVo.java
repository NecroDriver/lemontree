package com.xin.lemontree.vo;

import lombok.Data;

/**
 * @author creator mafh 2018/1/18 15:01
 * @author updater mafh
 * @version 1.0.0
 * @description 封装结果数据
 */
@Data
public class ResultVo<T> {
    /** 数据结果 */
    private boolean result;
    /** 数据 */
    private T data;
    /** 结果信息 */
    private String message;

    public ResultVo(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public ResultVo(boolean result, T data) {
        this.result = result;
        this.data = data;
    }
}
