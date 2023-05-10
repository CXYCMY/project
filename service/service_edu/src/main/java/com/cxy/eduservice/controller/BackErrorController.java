package com.cxy.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxy.commonutil.Result;
import com.cxy.eduservice.pojo.BackError;
import com.cxy.eduservice.pojo.EduTeacher;
import com.cxy.eduservice.pojo.User;
import com.cxy.eduservice.query.QueryUser;
import com.cxy.eduservice.service.BackErrorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: BackErrorController
 * @Package com.cxy.eduservice.config
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/10 21:32
 */
@RestController
@RequestMapping("/eduservice/back")
@CrossOrigin
public class BackErrorController {
    @Autowired
    private BackErrorService backErrorService;

    @ApiOperation(value = "新增反馈信息")
    @PostMapping("add")
    public Result add(@ApiParam(name = "back", value = "反馈对象", required = true)
                          @RequestBody BackError backError){
        boolean flag = backErrorService.save(backError);
        return flag?Result.ok():Result.error();

    }

    //更新反馈信息
    @ApiOperation(value = "更新反馈信息")
    @PostMapping("/updateBack")
    public Result updateBack(@RequestBody BackError backError){
        boolean flag = backErrorService.updateById(backError);
        return flag?Result.ok():Result.error();
    }

    @ApiOperation(value = "根据id值查找反馈信息")
    @GetMapping("/select/{id}")
    public Result findById(
            @ApiParam(name = "id",value = "传入的id值",required = true)
            @PathVariable String id){
        BackError backError = backErrorService.getById(id);
        return Result.ok().data("item",backError);

    }



    @ApiOperation(value = "对列表进行分页展示")
    @GetMapping("{page}/{limit}")
    public Result pageList(
            @ApiParam(name = "page",value = "当前页码")
            @PathVariable Long page,
            @ApiParam(name = "limit",value = "每页显示的数据条数")
            @PathVariable Long limit
    ){


        Page<BackError> pageParam=new Page<>(page,limit);//不能忘记参数，如果忘记的话会查所有

        backErrorService.page(pageParam);

        List<BackError> records = pageParam.getRecords();//数据的list集合
        System.out.println(records);
        long total = pageParam.getTotal();//总记录条数
        return Result.ok().data("total",total).data("rows",records);
    }


    @ApiOperation(value = "根据传入的id值进行数据的删除")
    @DeleteMapping("{id}")
    public Result deleted(
            @ApiParam(name = "id",value = "用户的id编号",required = true)
            @PathVariable String id){
        boolean flag = backErrorService.removeById(id);
        return flag?Result.ok():Result.error();
    }






}
