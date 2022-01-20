package com.wang.material;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: 项目启动
 * @author
 * @date 2022/1/17 9:11
 * @version 1.0
 */
@EnableScheduling
@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
@EnableAsync
@MapperScan("com.wang.**.mapper")
public class MaterialServiceApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(MaterialServiceApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
