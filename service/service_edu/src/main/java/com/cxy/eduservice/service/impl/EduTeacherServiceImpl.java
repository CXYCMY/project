package com.cxy.eduservice.service.impl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxy.eduservice.pojo.EduTeacher;
import com.cxy.eduservice.mapper.EduTeacherMapper;
import com.cxy.eduservice.query.QueryTeacher;
import com.cxy.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author CXY
 * @since 2023-03-12
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {


    @Override
    public void pageQuery(Page<EduTeacher> pageParam, QueryTeacher teacherQuery) {
        QueryWrapper<EduTeacher> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");//根据等级进行排序
        if (teacherQuery==null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return;
        }
        String name=teacherQuery.getName();
        Integer level=teacherQuery.getLevel();
        String gmtCreate=teacherQuery.getGmtCreate();
        String gmtModified= teacherQuery.getGmtModified();
        if(!StringUtils.isNullOrEmpty(name)){
            queryWrapper.like("name",name);
        }
        if(!StringUtils.isNullOrEmpty(gmtCreate)){
            queryWrapper.between("gmt_modify",gmtCreate,gmtModified);
        }
        if(!StringUtils.isNullOrEmpty(gmtModified)){
            queryWrapper.like("gmt_modified",gmtModified);
        }
        baseMapper.selectPage(pageParam,queryWrapper);

    }
}
