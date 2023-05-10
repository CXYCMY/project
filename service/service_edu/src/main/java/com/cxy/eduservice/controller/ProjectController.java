package com.cxy.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxy.commonutil.Result;

import com.cxy.eduservice.pojo.Project;

import com.cxy.eduservice.pojo.User;
import com.cxy.eduservice.query.QueryProject;
import com.cxy.eduservice.service.ProjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: ProjectController
 * @Package com.cxy.eduservice.controller
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/11 12:11
 */
@RestController
@RequestMapping("/eduservice/project")
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    //多条件组合查询
    @ApiOperation(value = "多条件组合查询")
    @PostMapping("getPageListProject/{page}/{limit}")
    public Result pageListQueryProject(
            @ApiParam(name = "page",value = "当前页码")
            @PathVariable Long page,
            @ApiParam(name = "limit",value = "每页显示的数据条数")
            @PathVariable Long limit,
            @ApiParam(name = "infoQuery", value = "查询对象", required = false)
            @RequestBody(required = false)
            QueryProject projectQuery
    ){
        Page<Project> pageParam=new Page<>(page,limit);//不能忘记参数，如果忘记的话会查所有
        QueryWrapper<Project> wrapper=new QueryWrapper<>();
        String begin=projectQuery.getProCreate();
        wrapper.orderByDesc("pro_create");
        projectService.projectQuery(pageParam,projectQuery);
        List<Project> records = pageParam.getRecords();//数据的list集合
        long total = pageParam.getTotal();//总记录条数
        return Result.ok().data("total",total).data("rows",records);
    }

    //删除用户
    @ApiOperation(value = "根据传入的id值进行数据的删除")
    @DeleteMapping("{id}")
    public Result deleted(
            @ApiParam(name = "id",value = "用户的id编号",required = true)
            @PathVariable String id){
        boolean flag = projectService.removeById(id);
        return flag?Result.ok():Result.error();
    }
//    根据id查找用户
    @GetMapping("/select/{id}")
    public Result findById(
            @ApiParam(name = "id",value = "传入的id值",required = true)
            @PathVariable String id){
        Project project = projectService.getById(id);
        return Result.ok().data("item",project);

    }

//    添加

    @PostMapping("add")
    public Result add(@RequestBody Project project){
        String name = project.getName();
        BaseMapper<Project> baseMapper = projectService.getBaseMapper();
        Project pro = baseMapper.selectOne(new QueryWrapper<Project>().eq("name", name));


        if (pro!=null){
            return Result.error().message("项目名重复");
        }
        boolean flag = projectService.save(project);
        return flag?Result.ok():Result.error();

    }


//    更新用户
    @PostMapping("updateUser")
    public Result updateUser(@RequestBody Project project){
        boolean flag=projectService.updateById(project);
        return flag?Result.ok():Result.error();
    }

    //查所有
    @GetMapping("/all")
    public Result findAll(){
        List<Project> list = projectService.list(null);
        return  Result.ok().data("item",list);

    }
}
