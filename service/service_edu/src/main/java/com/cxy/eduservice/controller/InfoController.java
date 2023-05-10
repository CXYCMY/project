package com.cxy.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxy.commonutil.Result;
import com.cxy.eduservice.pojo.Info;
import com.cxy.eduservice.pojo.User;
import com.cxy.eduservice.query.QueryInfo;
import com.cxy.eduservice.query.QueryUser;
import com.cxy.eduservice.service.InfoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: InfoController
 * @Package com.cxy.eduservice.controller
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/11 10:31
 */
@CrossOrigin
@RestController
@RequestMapping("/eduservice/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    //删除新闻信息
    @ApiOperation(value = "根据传入的id值进行数据的删除")
    @DeleteMapping("{id}")
    public Result deleted(
            @ApiParam(name = "id",value = "新闻的id编号",required = true)
            @PathVariable String id){
        boolean flag = infoService.removeById(id);
        return flag?Result.ok():Result.error();
    }

    @ApiOperation(value = "多条件组合查询")
    @PostMapping("getPageListInfo/{page}/{limit}")
    public Result pageListQueryInfo(
            @ApiParam(name = "page",value = "当前页码")
            @PathVariable Long page,
            @ApiParam(name = "limit",value = "每页显示的数据条数")
            @PathVariable Long limit,
            @ApiParam(name = "infoQuery", value = "查询对象", required = false)
            @RequestBody(required = false)
            QueryInfo infoQuery
    ){
        Page<Info> pageParam=new Page<>(page,limit);//不能忘记参数，如果忘记的话会查所有


        QueryWrapper<Info> wrapper=new QueryWrapper<>();
//        String begin=infoQuery.getInfoCreate();
//        wrapper.orderByDesc("info_create");
        infoService.infoQuery(pageParam,infoQuery);
        List<Info> records = pageParam.getRecords();//数据的list集合
        long total = pageParam.getTotal();//总记录条数
        return Result.ok().data("total",total).data("rows",records);
    }

    //根据id查找
    @ApiOperation(value = "根据id值查找")
    @GetMapping("/select/{id}")
    public Result findById(
            @ApiParam(name = "id",value = "传入的id值",required = true)
            @PathVariable String id){
        Info info = infoService.getById(id);
        return Result.ok().data("item",info);

    }


    //添加
    @ApiOperation(value = "新增新闻")
    @PostMapping("add")
    public Result add(@ApiParam(name = "info", value = "新闻对象", required = true)
                      @RequestBody Info info){
        boolean flag = infoService.save(info);
        return flag?Result.ok():Result.error();

    }


    //修改
    @PostMapping("updateUser")
    public Result updateUser(@RequestBody Info info){
        boolean flag=infoService.updateById(info);
        return flag?Result.ok():Result.error();
    }







}
