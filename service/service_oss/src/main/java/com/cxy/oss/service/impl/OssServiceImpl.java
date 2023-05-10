package com.cxy.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.cxy.oss.service.OssService;
import com.cxy.oss.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @Title: OssServiceImpl
 * @Package com.cxy.oss.service.impl
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/9 14:25
 */
@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFileAvatar(MultipartFile file) {

        String endPoint = ConstantPropertiesUtils.END_POINT;
        String keyId = ConstantPropertiesUtils.KEY_ID;
        String keySecret = ConstantPropertiesUtils.KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;
        try{
            //创建OSS实例
            OSS ossClient=new OSSClientBuilder().build(endPoint,keyId,keySecret);

//            上传文件流
            InputStream inputStream=file.getInputStream();
//            获取文件名称
            String fileName=file.getOriginalFilename();
//            调用oss方法实现上传
//            第一个参数：bucket名称
//            第二个参数：上传到oss文件路径和文件名称
//            第三个参数：文件流
//          在文件名称里面添加随机唯一的值
            String uuid= UUID.randomUUID().toString().replaceAll("-","");
            fileName=uuid+fileName;
//            把文件按照日期进行分类
//            获取当前日期
            String datePath=new DateTime().toString("yyyy/MM/dd");
//            拼接
            fileName=datePath+fileName;
            ossClient.putObject(bucketName,fileName,inputStream);
            ossClient.shutdown();

//            把上传之后的文件路径返回，需要把上传到阿里云oss路径手拼出来
            String url="http://"+bucketName+"."+endPoint+"/"+fileName;
            return url;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
