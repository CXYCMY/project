package com.cxy.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxy.eduservice.pojo.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxy.eduservice.query.QueryTeacher;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author CXY
 * @since 2023-03-12
 */
public interface EduTeacherService extends IService<EduTeacher> {

    void pageQuery(Page<EduTeacher> pageParam, QueryTeacher teacherQuery);
}
