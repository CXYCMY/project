package com.cxy.eduservice.query;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Title: QueryProject
 * @Package com.cxy.eduservice.query
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/11 12:17
 */
@ApiModel(value = "Project查询对象", description = "产业项目查询对象封装")
@Data
public class QueryProject {

    @ApiModelProperty(value = "负责人姓名")
    private String man;

    @ApiModelProperty(value = "项目所属地区")
    private String address;

    @ApiModelProperty(value = "创建时间")
    private String proCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String proModify;

}
