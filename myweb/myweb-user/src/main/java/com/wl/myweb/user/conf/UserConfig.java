package com.wl.myweb.user.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2016/8/17.
 */
@Configuration
@ComponentScan(basePackages = {"com.wl.myweb.user.resourceimpl",
        "com.wl.myweb.user.service",
        "com.wl.myweb.user.grade"})
@MapperScan("com.wl.myweb.user.service.mapper")
public class UserConfig {

}
