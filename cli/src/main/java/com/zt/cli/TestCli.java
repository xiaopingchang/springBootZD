package com.zt.cli;

import com.alibaba.fastjson.JSON;
import com.zt.cli.Service.Demo2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by gaoxuejian on 2018/12/25.
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("com.zt")

public class TestCli implements CommandLineRunner {
    @Autowired
    private Demo2Service demo2Service;
    public void run(String... strings) throws Exception {
        System.out.println(JSON.toJSONString(demo2Service.getUserInfo("1000000002")));
    }
    public static void main(String[] args) {
        new SpringApplicationBuilder(TestCli.class).web(WebApplicationType.NONE).run();
    }

}
