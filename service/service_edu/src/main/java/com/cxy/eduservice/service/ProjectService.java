package com.cxy.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxy.eduservice.pojo.Project;
import com.cxy.eduservice.query.QueryProject;

public interface ProjectService extends IService<Project> {
    void projectQuery(Page<Project> pageParam, QueryProject projectQuery);
}
