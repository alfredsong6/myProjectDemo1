package com.demo.springscheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages="com.demo.springscheduling.mapper")
public class SpringSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSchedulingApplication.class, args);
    }

}
