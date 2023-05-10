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
 * @Title: Info
 * @Package com.cxy.eduservice.pojo
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/11 10:15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Info对象", description="新闻资讯")
@Api(tags = {SwaggerConfig.TAG_1})
public class Info {
    @ApiModelProperty(value = "新闻ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "新闻标题")
    private String name;

    @ApiModelProperty(value = "新闻提交人姓名")
    private String username;

    @ApiModelProperty(value = "新闻链接")
    private String href;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date infoCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date infoModify;

    @ApiModelProperty(value = "地区")
    private String address;

    @ApiModelProperty(value = "新闻图片")
    private String avatar;

}
