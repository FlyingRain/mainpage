package com.wl.myweb.basic.conf;



/**
 * Created by Administrator on 2016/8/17.
 */

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@Import(MybatisConfig.class)
@PropertySource("classpath:/baseConf/jdbc.properties")
public class BasicConfig {

    @Autowired
    Environment em;
    @Bean
    DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(em.getProperty("jdbc.driverName"));
        dataSource.setUsername(em.getProperty("jdbc.userName"));
        dataSource.setPassword(em.getProperty("jdbc.password"));
        dataSource.setUrl(em.getProperty("jdbc.url"));

        return dataSource;
    }
}
