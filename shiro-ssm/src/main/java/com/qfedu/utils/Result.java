package com.qfedu.utils;

import java.util.HashMap;

/**
 * projectName:MybatisPlus
 * author:zzq
 * time:2023/4/25 11:44
 * description:
 */
public class Result extends HashMap {

    private  int code;//状态 0 成功  1 失败
    private  String msg;//响应的信息

    public Result(){}
    public Result(int code){
        super.put("code",code);
    }

    public Result(int code, String msg){
        super.put("code",code);
        super.put("msg",msg);
    }

    public  static Result ok(){
        return new Result(0);
    }
    public  static Result ok(String msg){
        return new Result(0,msg);
    }

    public  static Result error(){
        return new Result(1);
    }
    public  static Result error(String msg){
        return new Result(1,msg);
    }

    public Result put(String key, Object value){
        super.put(key,value);

        return this;
    }


}
