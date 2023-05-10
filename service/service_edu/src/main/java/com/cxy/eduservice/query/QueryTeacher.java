package com.cxy.eduservice.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Title: QueryTeacher
 * @Package com.cxy.eduservice.query
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/3/13 13:08
 */
@ApiModel(value = "Teacher查询对象", description = "讲师查询对象封装")
@Data
public class QueryTeacher {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "教师名称,模糊查询")
    private String name;
    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;
    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String gmtCreate; //注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String gmtModified;

}
