package com.cxy.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title: OssApplication
 * @Package com.cxy.oss
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/4/9 13:51
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//加上这个表示不回去加载数据库，就不需要配置数据库信息了，否则还是需要在application.properties中添加配置信息
@ComponentScan(basePackages = {"com.cxy"})
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class,args);
        System.out.println("成功运行");
    }
}
