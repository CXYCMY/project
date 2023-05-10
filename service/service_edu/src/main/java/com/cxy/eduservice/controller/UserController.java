package com.cxy.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxy.commonutil.JwtUtils;
import com.cxy.commonutil.MD5Utils;
import com.cxy.commonutil.Result;
import com.cxy.eduservice.exception.GuliException;
import com.cxy.eduservice.pojo.EduTeacher;
import com.cxy.eduservice.pojo.User;
import com.cxy.eduservice.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @Title: UserController
 * @Package com.cxy.eduservice.controller
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/8 9:46
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @ApiOperation(value = "用户登录")
    @PostMapping("login")
    public Result login(@RequestBody User userParam) {
        String token = userService.login(userParam);
        return Result.ok().data("token", token);
    }

    @ApiOperation(value = "注册用户")
    @PostMapping("add")
    public Result add(@ApiParam(name = "user", value = "普通用户对象", required = true)
                      @RequestBody User user){
        //前端传过来了一个user对象
        //给user对象的name付初始值
        String username = user.getUsername();
        String password=user.getPassword();
        user.setPassword(MD5Utils.md5(password));
        //设置默认头像
        user.setAvatar("https://educxy.oss-cn-shenzhen.aliyuncs.com/2023/04/09b26e6bfece2a41199a8bb6f2e1b00173file.png");
        BaseMapper<User> baseMapper = userService.getBaseMapper();
        Integer count= baseMapper.selectCount(new QueryWrapper<User>().eq("username", username));
        //判断username在数据库中是否存在，就可以直接根据username进行查询
        if (count > 0){
            return Result.error().message("用户名重复");
        }
        //保存前端传过来的user对象到数据库中
        boolean flag = userService.save(user);
        return flag?Result.ok().data("user",user):Result.error();

    }
    @ApiOperation(value = "根据token获取登录信息")
    @GetMapping("getLoginInfo")
    public Result getLoginInfo(HttpServletRequest request) {
        try {
            String userId = JwtUtils.getMemberIdByJwtToken(request);
            User user = userService.getById(userId);
//            user.setPassword(MD5Utils.md5(user.getPassword()));
//            System.out.println(user.getPassword());
            return Result.ok().data("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GuliException(20001, "获取用户信息失败");
        }
    }

    //修改用户信息



}
