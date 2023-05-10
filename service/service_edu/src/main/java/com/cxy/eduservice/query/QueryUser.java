package com.cxy.eduservice.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Title: QueryUser
 * @Package com.cxy.eduservice.query
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/8 20:20
 */
@ApiModel(value = "User查询对象", description = "讲师查询对象封装")
@Data
public class QueryUser {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "用户名称,模糊查询")
    private String name;
    @ApiModelProperty(value = "性别高级讲师 2首席讲师")
    private Integer sex;
    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String userCreate; //注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String userModify;
}
