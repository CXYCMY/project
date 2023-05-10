package com.cxy.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxy.commonutil.JwtUtils;
import com.cxy.commonutil.MD5Utils;
import com.cxy.eduservice.exception.GuliException;
import com.cxy.eduservice.mapper.UserMapper;
import com.cxy.eduservice.pojo.User;
import com.cxy.eduservice.query.QueryUser;
import com.cxy.eduservice.service.UserService;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

/**
 * @Title: UserServiceImpl
 * @Package com.cxy.eduservice.service.impl
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/7 20:06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public void userQuery(Page<User> pageParam, QueryUser userQuery) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByAsc("id");//根据id进行排序
        if (userQuery==null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return;
        }
        String name=userQuery.getName();
        String userCreate = userQuery.getUserCreate();
        String userModify = userQuery.getUserModify();
        Integer sex = userQuery.getSex();
        if(!StringUtils.isNullOrEmpty(name)){
            queryWrapper.like("name",name);
        }
        if(!StringUtils.isNullOrEmpty(userCreate)){
            queryWrapper.like("user_create",userCreate);
        }
        if(!StringUtils.isNullOrEmpty(userModify)){
            queryWrapper.like("user_modify",userModify);
        }
        if(sex!=null){
            if(sex<=1){
                queryWrapper.like("sex",sex);
            }
        }


        baseMapper.selectPage(pageParam,queryWrapper);

    }

    @Override
    public String login(User userParam) {
        String username=userParam.getUsername();
        String password=userParam.getPassword();


        if(StringUtils.isNullOrEmpty(username) ||
                StringUtils.isNullOrEmpty(password) ||
                StringUtils.isNullOrEmpty(username)) {
            throw new GuliException(20001,"error");
        }
//获取会员
        User user = baseMapper.selectOne(new
                QueryWrapper<User>().eq("username", username));
        if(user ==null) {
            throw new GuliException(20001,"error");
        }
//校验密码
        if(!MD5Utils.md5(password).equals(user.getPassword())) {
            throw new GuliException(20001,"error");
        }
//        System.out.println(MD5Utils.md5(password));
//        System.out.println(user.getPassword());
//校验是否被禁用



            if(user.getUserDelete()==1) {
                throw new GuliException(20001, "error");
            }


        //使用JWT生成token字符串
        String token = JwtUtils.getJwtToken(user.getId(), user.getName());
        return token;
    }
}

