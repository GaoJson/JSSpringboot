package com.example.boot.tools;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ApiResponse<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public ApiResponse(Integer code, String message){
        this.code = code;
        this.msg = message;
    }
    public static String response(Integer code,String msg,Object data){
        JSONObject object = new JSONObject();
        object.put("code",code);
        object.put("msg",msg);
        object.put("data",data);
        return object.toJSONString();
    }


}
