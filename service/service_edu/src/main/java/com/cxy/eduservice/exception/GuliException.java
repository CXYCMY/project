package com.cxy.eduservice.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: GuliException
 * @Package com.cxy.eduservice.exception
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/9 22:17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuliException extends RuntimeException {
    @ApiModelProperty(value = "状态码")
    private Integer code;
    private String msg;

}
