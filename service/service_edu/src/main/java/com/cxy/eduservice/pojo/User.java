package com.cxy.eduservice.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.cxy.servicebase.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.UUID;

/**
 * @Title: User
 * @Package com.cxy.eduservice.pojo
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/7 18:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="普通用户")
@Api(tags = {SwaggerConfig.TAG_1})
public class User {
    @ApiModelProperty(value = "用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户账号")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Integer userDelete;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date userCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date userModify;

    @ApiModelProperty(value = "用户昵称")
    private String name;

    @ApiModelProperty(value = "用户性别")
    private Integer sex;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @ApiModelProperty(value = "用户介绍")
    private String intro;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户地址")
    private String address;


}
