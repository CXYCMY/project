package com.cxy.eduservice.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.cxy.servicebase.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Title: Project
 * @Package com.cxy.eduservice.pojo
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/11 12:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Project对象", description="产业项目")
@Api(tags = {SwaggerConfig.TAG_1})
public class Project {
    @ApiModelProperty(value = "项目ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date proCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date proModify;

    @ApiModelProperty(value = "项目内容")
    private String content;

    @ApiModelProperty(value = "项目预算")
    private Integer money;

    @ApiModelProperty(value = "项目收藏标志")
    private Integer shou;

    @ApiModelProperty(value = "负责人姓名")
    private String man;

    @ApiModelProperty(value = "项目类型")
    private String type;

    @ApiModelProperty(value = "项目类型")
    private String username;

    @ApiModelProperty(value = "项目所属地区")
    private String address;

    @ApiModelProperty(value = "项目封面")
    private String avatar;


}
