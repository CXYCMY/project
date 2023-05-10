package com.cxy.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxy.eduservice.pojo.Info;
import com.cxy.eduservice.pojo.User;
import com.cxy.eduservice.query.QueryInfo;
import com.cxy.eduservice.query.QueryUser;

public interface InfoService extends IService<Info> {
    public void infoQuery(Page<Info> pageParam, QueryInfo infoQuery);
}
