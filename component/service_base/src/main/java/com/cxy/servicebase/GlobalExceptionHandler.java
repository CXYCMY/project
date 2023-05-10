package com.cxy.servicebase;

import com.cxy.commonutil.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @Title: GlobalExceptionHandler
 * @Package com.cxy.servicebase
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/3/13 14:22
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error().message("执行了全局异常处理");
    }
    //添加自定义异常处理方法
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result error(MyException e) {

        e.printStackTrace();
        //返回类型是Result类中定义的类型
        return Result.error().message(e.getMsg()).code(e.getCode());
    }
    }
