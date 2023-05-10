package com.cxy.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxy.commonutil.Result;
import com.cxy.eduservice.pojo.EduTeacher;
import com.cxy.eduservice.pojo.User;
import com.cxy.eduservice.query.QueryTeacher;
import com.cxy.eduservice.query.QueryUser;
import com.cxy.eduservice.service.EduTeacherService;
import com.cxy.eduservice.service.UserService;
import com.cxy.servicebase.MyException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author CXY
 * @since 2023-03-12
 */
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class EduTeacherController {
    //http://localhost:8001/service/teacher/all
    @Resource
    private EduTeacherService eduTeacherService;

    @Resource
    private UserService userService;
    @ApiOperation(value = "查看讲师的所有信息列表")
    @GetMapping("/all")
    public Result findAll(){
        List<User> list = userService.list(null);
        return  Result.ok().data("item",list);

    }
    @ApiOperation(value = "根据传入的id值进行数据的删除")
    @DeleteMapping("{id}")
    public Result deleted(
            @ApiParam(name = "id",value = "用户的id编号",required = true)
            @PathVariable String id){
        boolean flag = userService.removeById(id);
        return flag?Result.ok():Result.error();
    }

    //分页功能
    @ApiOperation(value = "对列表进行分页展示")
    @GetMapping("{current}/{limit}")
    public Result pageList(
            @ApiParam(name = "page",value = "当前页码")
            @PathVariable Long page,
            @ApiParam(name = "limit",value = "每页显示的数据条数")
            @PathVariable Long limit
    ){

        Page<EduTeacher> pageParam=new Page<>(page,limit);//不能忘记参数，如果忘记的话会查所有
         eduTeacherService.page(pageParam, null);
        List<EduTeacher> records = pageParam.getRecords();//数据的list集合
        long total = pageParam.getTotal();//总记录条数


        return Result.ok().data("total",total).data("rows",records);
    }


    //条件查询分页
    //分页功能
    @ApiOperation(value = "多条件组合查询")
    @PostMapping("getPageListUser/{page}/{limit}")
    public Result pageListQueryUser(
            @ApiParam(name = "page",value = "当前页码")
            @PathVariable Long page,
            @ApiParam(name = "limit",value = "每页显示的数据条数")
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            @RequestBody(required = false)
            QueryUser userQuery
    ){
        Page<User> pageParam=new Page<>(page,limit);//不能忘记参数，如果忘记的话会查所有


        QueryWrapper<User> wrapper=new QueryWrapper<>();
//        String begin=userQuery.getUserCreate();
//        wrapper.orderByDesc("user_create");
        userService.userQuery(pageParam,userQuery);
        List<User> records = pageParam.getRecords();//数据的list集合
        long total = pageParam.getTotal();//总记录条数
        return Result.ok().data("total",total).data("rows",records);
    }

//    新增讲师用户
    @ApiOperation(value = "新增讲师用户")
    @PostMapping("add")
    public Result add(@ApiParam(name = "user", value = "用户对象", required = true)
                          @RequestBody User user){
        String username = user.getUsername();
        BaseMapper<User> baseMapper = userService.getBaseMapper();
        User user2 = baseMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        //判断username在数据库中是否存在，就可以直接根据username进行查询
        System.out.println(user2);
        if (user2!=null){
            return Result.error().message("用户名重复");
        }
        boolean flag = userService.save(user);
        return flag?Result.ok():Result.error();

    }
    //根据id查找
    @ApiOperation(value = "根据id值查找讲师")
    @GetMapping("/select/{id}")
    public Result findById(
            @ApiParam(name = "id",value = "传入的id值",required = true)
            @PathVariable String id){
        User user = userService.getById(id);
        return Result.ok().data("item",user);

    }

    //根据id进行修改信息
    @ApiOperation(value = "根据id值进行修改信息")
    @PutMapping("/modify/{id}")
    public Result modifyById(
            @ApiParam(name = "id",value = "讲师id",required = true)
            @PathVariable String id,
            @ApiParam(name = "eduTeacher",value = "讲师对象",required = true)
            @RequestBody EduTeacher eduTeacher
            ){
        eduTeacher.setId(id);
        boolean flag = eduTeacherService.updateById(eduTeacher);
        return flag?Result.ok():Result.error();

    }
    //用户修改功能
    @PostMapping("updateUser")
    public Result updateUser(@RequestBody User user){
        boolean flag=userService.updateById(user);
        return flag?Result.ok():Result.error();
    }

}

