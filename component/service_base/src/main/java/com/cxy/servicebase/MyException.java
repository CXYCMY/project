package com.cxy.servicebase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: MyException
 * @Package com.cxy.servicebase
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/3/14 10:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    private String msg;

    @Override
    public String toString() {
        return "GuliException{" +
                "message=" + this.getMessage() +
                ", code=" + code +
                '}';
    }
    }
