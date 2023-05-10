package com.cxy.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxy.commonutil.JwtUtils;
import com.cxy.commonutil.MD5Utils;
import com.cxy.eduservice.exception.GuliException;
import com.cxy.eduservice.mapper.AdminMapper;
import com.cxy.eduservice.pojo.Admin;
import com.cxy.eduservice.service.AdminService;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @Title: AdminServiceImpl
 * @Package com.cxy.eduservice.service.impl
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/12 21:07
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {


}
