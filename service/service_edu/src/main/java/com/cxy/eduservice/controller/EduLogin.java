package com.cxy.eduservice.controller;

import com.cxy.commonutil.JwtUtils;
import com.cxy.commonutil.Result;
import com.cxy.eduservice.pojo.Admin;
import com.cxy.eduservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title: EduLogin
 * @Package com.cxy.eduservice.controller
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/3/14 14:41
 */
@CrossOrigin
@RestController
@RequestMapping("/eduservice/user1")
public class EduLogin {
    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public Result login(@RequestBody Admin admin){
//        System.out.println(admin);

        return Result.ok().data("token","admin");
    }

    @GetMapping("info")
    public Result info(){

                return Result.ok().data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

    @PostMapping("logout")
    public Result loginOut(){
        return Result.ok();
    }
}
