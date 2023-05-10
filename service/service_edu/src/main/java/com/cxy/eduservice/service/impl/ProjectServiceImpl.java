package com.cxy.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxy.eduservice.mapper.ProjectMapper;
import com.cxy.eduservice.pojo.Info;
import com.cxy.eduservice.pojo.Project;
import com.cxy.eduservice.query.QueryProject;
import com.cxy.eduservice.service.ProjectService;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.lang.model.element.VariableElement;

/**
 * @Title: ProjectServiceImpl
 * @Package com.cxy.eduservice.service.impl
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/11 12:10
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    @Override
    public void projectQuery(Page<Project> pageParam, QueryProject projectQuery) {
        QueryWrapper<Project> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByAsc("id");//根据id进行排序
        if (projectQuery==null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return;
        }

        String man = projectQuery.getMan();
        String address = projectQuery.getAddress();
        String begin = projectQuery.getProCreate();
        String end = projectQuery.getProModify();

        if(!StringUtils.isNullOrEmpty(man)){
            queryWrapper.like("man",man);
        }
        if(!StringUtils.isNullOrEmpty(begin)){
            queryWrapper.like("pro_create",begin);
        }
        if(!StringUtils.isNullOrEmpty(end)){
            queryWrapper.like("pro_modify",end);
        }
        if(!StringUtils.isNullOrEmpty(address)){
            queryWrapper.like("address",address);
        }

        baseMapper.selectPage(pageParam,queryWrapper);
    }
}
