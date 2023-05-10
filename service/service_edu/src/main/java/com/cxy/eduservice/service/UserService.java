package com.cxy.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxy.eduservice.pojo.User;
import com.cxy.eduservice.query.QueryUser;

public interface UserService extends IService<User> {

    public void userQuery(Page<User> pageParam, QueryUser userQuery);

    String login(User userParam);
}
