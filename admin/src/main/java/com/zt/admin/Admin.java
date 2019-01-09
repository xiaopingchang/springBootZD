package com.zt.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by gaoxuejian on 2018/12/25.
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("com.zt")
public class Admin extends SpringBootServletInitializer {
    public static void main(String[] args)  throws Exception{
        SpringApplication.run(Admin.class,args);
    }
}
