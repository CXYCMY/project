package com.cxy.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Title: ConstantPropertiesUtils
 * @Package com.cxy.oss.utils
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/9 14:12
 */
//负责读取配置文件的数据
//当项目一启动的时候，执行spring中一个接口的方法
@Component
public class ConstantPropertiesUtils implements InitializingBean {
    //读取配置文件，通过@value
    @Value("${aliyun.oss.file.endpoint}")
    private String endPoint;

    @Value("${aliyun.oss.file.keyid}")
    private String keyId;

    @Value("${aliyun.oss.file.keysecret}")
    private String keySecret;

    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName;

    //定义公开静态常量
    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BUCKET_NAME;


    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT=endPoint;
        KEY_ID=keyId;
        KEY_SECRET=keySecret;
        BUCKET_NAME=bucketName;

    }
}
