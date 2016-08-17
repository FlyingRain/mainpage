package com.wl.applictaion;

import com.wl.applictaion.containers.ResourceContainer;
import com.wl.myweb.api.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wul on 2016/8/16.
 */
public class ApplicationRegister {

    private Logger logger = LoggerFactory.getLogger(ApplicationRegister.class);

    private Map<String,ApplicationContext> contextContainer = new HashMap();

    private ResourceContainer resourceContainer = new ResourceContainer();

    public Map<String, ApplicationContext> getContextContainer() {
        return contextContainer;
    }

    public void setContextContainer(Map<String, ApplicationContext> contextContainer) {
        this.contextContainer = contextContainer;
    }

    public ResourceContainer getResourceContainer() {
        return resourceContainer;
    }

    public void setResourceContainer(ResourceContainer resourceContainer) {
        this.resourceContainer = resourceContainer;
    }

    public void  registe(String module,ApplicationContext applicationContext){

        contextContainer.put(module,applicationContext);
        logger.info("start find rest resources!");
        Map<String,Resource> resources = applicationContext.getBeansOfType(Resource.class);
        for(String key : resources.keySet()){
            Resource resource = resources.get(key);
            resourceContainer.addResources(resource);
        }

    }

}
