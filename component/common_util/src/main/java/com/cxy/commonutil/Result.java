package com.cxy.commonutil;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: Result结果类
 * @Package com.cxy.commonutil
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/3/13 12:25
 */
@Data
public class Result {
//    私有化构造方法，使他成为单例，外部无法进行new对象
    private Result(){}

    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "返回码")
    private Integer code;
    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回的数据格式")
    HashMap<String,Object> data=new HashMap<>();

//    访问成功返回数据格式方法

    public static Result ok(){
        Result r=new Result();//因为是在本类中，所以可以new对象
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    /**
     * 失败的数据格式返回方法
     * @return
     */
    public static Result error() {
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    public Result message(String message){
        this.setMessage(message);
        return this;
    }
    public Result code(Integer code){
        this.setCode(code);
        return this;
    }
    public Result data(String key, Object value){
        this.data.put(key, value);
        return this;
    }
    public Result data(HashMap<String, Object> map) {
        this.setData(map);
        return this;
    }

    }
