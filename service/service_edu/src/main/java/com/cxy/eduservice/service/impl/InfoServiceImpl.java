package com.cxy.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxy.eduservice.mapper.InfoMapper;
import com.cxy.eduservice.mapper.UserMapper;
import com.cxy.eduservice.pojo.Info;
import com.cxy.eduservice.pojo.User;
import com.cxy.eduservice.query.QueryInfo;
import com.cxy.eduservice.service.InfoService;
import com.cxy.eduservice.service.UserService;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @Title: InfoServiceImpl
 * @Package com.cxy.eduservice.service.impl
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/11 10:29
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements InfoService {

    @Override
    public void infoQuery(Page<Info> pageParam, QueryInfo infoQuery) {
        QueryWrapper<Info> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByAsc("id");//根据id进行排序
        if (infoQuery==null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return;
        }
        String username=infoQuery.getUsername();
        String address=infoQuery.getAddress();

        String begin=infoQuery.getInfoCreate();
        String end= infoQuery.getInfoModify();
        if(!StringUtils.isNullOrEmpty(username)){
            queryWrapper.like("username",username);
        }
        if(!StringUtils.isNullOrEmpty(begin)){
            queryWrapper.like("info_create",begin);
        }
        if(!StringUtils.isNullOrEmpty(end)){
            queryWrapper.like("info_modify",end);
        }
        if(!StringUtils.isNullOrEmpty(address)){
            queryWrapper.like("address",address);
        }

        baseMapper.selectPage(pageParam,queryWrapper);
    }
}
