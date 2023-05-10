package com.cxy.eduservice.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.cxy.servicebase.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Title: Submit
 * @Package com.cxy.eduservice.pojo
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/11 13:23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Submit对象", description="申请加入项目")
@Api(tags = {SwaggerConfig.TAG_1})
public class Submit {
    @ApiModelProperty(value = "项目ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "申请项目名称")
    private String proName;

    @ApiModelProperty(value = "申请项目类别")
    private String proType;

    @ApiModelProperty(value = "申请的普通用户姓名")
    private String userName;

    @ApiModelProperty(value = "申请的普通用户账号")
    private String userUsername;

    @ApiModelProperty(value = "申请项目状态")
    private String type;

    @ApiModelProperty(value = "申请项目所属地区")
    private String proAddress;

    @ApiModelProperty(value = "申请项目的预算")
    private String proMoney;

    @ApiModelProperty(value = "申请项目理由")
    private String message;

    @ApiModelProperty(value = "项目审核意见")
    private String backMessage;

    @ApiModelProperty(value = "项目内容")
    private String proContent;

    @ApiModelProperty(value = "申请创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date submitCreate;



}
