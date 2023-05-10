package com.cxy.eduservice.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Title: MyMetaObjectHandler
 * @Package com.cxy.eduservice.handler
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/3/13 13:59
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate", new Date(), metaObject);

        this.setFieldValByName("userCreate", new Date(), metaObject);
        this.setFieldValByName("userModify", new Date(), metaObject);

        this.setFieldValByName("backCreate",new Date(),metaObject);

        this.setFieldValByName("proCreate",new Date(),metaObject);
        this.setFieldValByName("infoCreate",new Date(),metaObject);
        this.setFieldValByName("infoModify",new Date(),metaObject);

        this.setFieldValByName("proModify",new Date(),metaObject);

        this.setFieldValByName("submitCreate",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        this.setFieldValByName("gmtModified", new Date(), metaObject);

        this.setFieldValByName("userModify", new Date(), metaObject);

        this.setFieldValByName("proModify",new Date(),metaObject);
        this.setFieldValByName("infoModify",new Date(),metaObject);
    }

}
