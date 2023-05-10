package com.cxy.eduservice.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.cxy.servicebase.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: Admin
 * @Package com.cxy.eduservice.pojo
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/12 21:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Admin {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String password;
    private String avatar;
}
