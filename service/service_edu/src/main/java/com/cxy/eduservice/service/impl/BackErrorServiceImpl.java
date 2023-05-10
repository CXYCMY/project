package com.cxy.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxy.eduservice.mapper.BackErrorMapper;
import com.cxy.eduservice.mapper.EduTeacherMapper;
import com.cxy.eduservice.pojo.BackError;
import com.cxy.eduservice.pojo.EduTeacher;
import com.cxy.eduservice.pojo.User;
import com.cxy.eduservice.service.BackErrorService;
import com.cxy.eduservice.service.EduTeacherService;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @Title: BackErrorServiceImpl
 * @Package com.cxy.eduservice.service.impl
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/10 21:31
 */
@Service
public class BackErrorServiceImpl extends ServiceImpl<BackErrorMapper, BackError> implements BackErrorService {

}
