package com.cxy.eduservice.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Title: QueryInfo
 * @Package com.cxy.eduservice.query
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/11 10:43
 */
@ApiModel(value = "Info查询对象", description = "新闻查询对象封装")
@Data
public class QueryInfo {
//    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新闻提交人")
    private String username;

    @ApiModelProperty(value = "新闻所属地区")
    private String address;
    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String infoCreate; //注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String infoModify;
}
