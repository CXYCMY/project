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
 * @Title: BackError
 * @Package com.cxy.eduservice.pojo
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/10 21:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BackError对象", description="问题反馈")
@Api(tags = {SwaggerConfig.TAG_1})
public class BackError {
    @ApiModelProperty(value = "问题ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户账号")
    private String username;

    @ApiModelProperty(value = "问题内容")
    private String message;

    @ApiModelProperty(value = "处理信息")
    private String back;

    @ApiModelProperty(value = "联系方式")
    private String mail;

    @ApiModelProperty(value = "反馈类型")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date backCreate;


}
