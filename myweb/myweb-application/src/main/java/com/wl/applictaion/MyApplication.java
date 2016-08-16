package com.wl.applictaion;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by wl on 16-8-15.
 */

public class MyApplication extends Application<MyConfig> {

    Logger logger = LoggerFactory.getLogger(MyApplication.class);

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<MyConfig> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(MyConfig myConfig, Environment environment) throws Exception {

        String startModule = myConfig.getStartModule();
        logger.info("startModule:" + startModule);
        String modules[] = startModule.split(",");
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext();



    }
}
