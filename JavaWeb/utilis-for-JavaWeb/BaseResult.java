package com.hzlx.utils;

/**
 * Description:
 *  自定义查询返回数据的code码及信息
 * @author: Corgi Cheul
 * @Date: 2023/5/24 16:46
 * Created with Intellij IDEA
 * To change this template use File|Settings|Flie And Code Templates
 */
public class BaseResult<T> {
    private Integer code;
    private String msg;
    private T data;

    private BaseResult() {
    }

    private BaseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static BaseResult success() {
        return new BaseResult(200, "success", null);
    }

    public static <T> BaseResult success(T data) {
        return new BaseResult(200, "success", data);
    }

    public static BaseResult error(Integer code, String msg) {
        return new BaseResult(code, msg, null);
    }
}
