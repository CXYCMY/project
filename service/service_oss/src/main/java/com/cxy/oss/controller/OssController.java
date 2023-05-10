package com.cxy.oss.controller;

import com.cxy.commonutil.Result;
import com.cxy.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Title: OssController
 * @Package com.cxy.oss.controller
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/9 14:26
 */
@RestController
@RequestMapping("/eduoss/file")
@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;

    //上传头像的方法
    @PostMapping
    public Result uploadOssFile(MultipartFile file){
        String url=ossService.uploadFileAvatar(file);
        return Result.ok().data("url",url);
    }
}
