package com.example.core.shiro;





/**
 * rest请求的响应实体类
 */

public class JsonResult {
    /**
     * 错误代码
     * 0：未出错
     */

    private Integer code;
    /**
     * 错误消息
     * 默认为空字符串
     */
    private String msg;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 返回的数据
     */


    private JsonResult() {
    }

    private JsonResult(Integer code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.data = obj;
    }

    public static JsonResult OK() {
        return new JsonResult(0, "success", null);
    }

    public static JsonResult OK(Object obj) {
        return new JsonResult(0, "success", obj);
    }

    public static JsonResult Err(Integer err, String msg, Object obj) {
        return new JsonResult(err, msg, obj);
    }

    public static JsonResult Err(Integer err, String msg) {
        return new JsonResult(err, msg, null);
    }

    public static JsonResult Err(ResultCode resultCode) {
        return new JsonResult(resultCode.code(), resultCode.msg(), null);
    }

}
