package com.cxy.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxy.commonutil.Result;
import com.cxy.eduservice.pojo.*;
import com.cxy.eduservice.service.SubmitService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: SubmitController
 * @Package com.cxy.eduservice.controller
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/11 13:32
 */
@RestController
@RequestMapping("/eduservice/submit")
@CrossOrigin
public class SubmitController {
    @Autowired
    private SubmitService submitService;
    @ApiOperation(value = "对列表进行分页展示")
    @GetMapping("{page}/{limit}")
    public Result pageList(
            @ApiParam(name = "page",value = "当前页码")
            @PathVariable Long page,
            @ApiParam(name = "limit",value = "每页显示的数据条数")
            @PathVariable Long limit
    ){


        Page<Submit> pageParam=new Page<>(page,limit);//不能忘记参数，如果忘记的话会查所有

        submitService.page(pageParam);

        List<Submit> records = pageParam.getRecords();//数据的list集合
        System.out.println(records);
        long total = pageParam.getTotal();//总记录条数
        return Result.ok().data("total",total).data("rows",records);
    }
//根据id查找
    @GetMapping("/select/{id}")
    public Result findById(
            @ApiParam(name = "id",value = "传入的id值",required = true)
            @PathVariable String id){
        Submit submit = submitService.getById(id);
        return Result.ok().data("item",submit);

    }
//  更新项目内容
    @PostMapping("updateUser")
    public Result updateUser(@RequestBody Submit submit){
        boolean flag=submitService.updateById(submit);
        return flag?Result.ok():Result.error();
    }
//    删除
@ApiOperation(value = "根据传入的id值进行数据的删除")
@DeleteMapping("{id}")
    public Result deleted(@PathVariable String id){
        boolean flag = submitService.removeById(id);
        return flag?Result.ok():Result.error();
    }


    //添加用户
    @PostMapping("add")
    public Result add(@RequestBody Submit submit){
        boolean flag = submitService.save(submit);
        return flag?Result.ok():Result.error();
    }

    @ApiOperation(value = "查看讲师的所有信息列表")
    @GetMapping("/all")
    public Result findAll(){
        List<Submit> list = submitService.list(null);
        return  Result.ok().data("item",list);

    }


}
