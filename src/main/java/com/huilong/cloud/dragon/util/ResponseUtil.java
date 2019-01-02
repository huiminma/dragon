package com.huilong.cloud.dragon.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zhanghuilong
 * @desc
 * @since 2018/11/13
 */
public class ResponseUtil {

    public static <T> String success(){
        ResponseVO response = new ResponseVO(200,"成功", null);
        return JSONObject.toJSONString(response);
    }
    public static <T> String success(T data){
        ResponseVO response = new ResponseVO(200,"成功", data);
        return JSONObject.toJSONString(response);
    }

    public static <T> String error() {
        ResponseVO response = new ResponseVO(-1,"失败", null);
        return JSONObject.toJSONString(response);
    }
}
