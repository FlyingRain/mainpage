package com.wl.applictaion;

import com.codahale.metrics.MetricRegistry;
import com.wl.applictaion.containers.ResourceContainer;
import com.wl.myweb.basic.utils.PropertyUtil;
import io.dropwizard.Application;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.DispatcherType;
import java.util.*;

/**
 * Created by wl on 16-8-15.
 */

public class MyApplication extends Application<MyConfig> {

    Logger logger = LoggerFactory.getLogger(MyApplication.class);

    private ApplicationRegister applicationRegister = new ApplicationRegister();

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
        List<String> moduleList = Arrays.asList(modules);
        PropertyUtil util = new PropertyUtil();
        logger.info("start init property!");
        util.init(moduleList);
        logger.info("get modules: " + Arrays.deepToString(modules));
        reigisterModules(modules);

        environment.servlets().addFilter("CrossOriginFilter", new CrossOriginFilter())
                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
        //注册rest服务
        JerseyEnvironment je = environment.jersey();
        ResourceContainer resourceContainer = applicationRegister.getResourceContainer();
        if(resourceContainer==null){
            logger.error("no resource to be registered");
            return;
        }
        resourceContainer.getResources().forEach(resource->{
            je.register(resource);
        });




    }

    //层次化加入spring框架
    private void reigisterModules(String[] modules) {

        Class<?> base = null;
        try {
            base = Class.forName("com.wl.myweb.basic.conf.BasicConfig");
        } catch (ClassNotFoundException e) {
            logger.error("class not found!", e);

        }
       //注入基础配置
        AnnotationConfigApplicationContext root = new AnnotationConfigApplicationContext(base);

        for (String module : modules) {

            String mname = module.substring(0, 1).toUpperCase() + module.substring(1)+ "Config";

            String moduleName = String.format("com.wl.myweb.%s.conf.%s", module, mname);
            try {
                Class<?> cmoduleName = Class.forName(moduleName);

                AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
                context.setParent(root);
                context.register(cmoduleName);
                context.refresh();
//注册服务
                applicationRegister.registe(module,context);

            } catch (ClassNotFoundException e) {
                logger.error("class not found!", e);
            }

        }

    }
}
