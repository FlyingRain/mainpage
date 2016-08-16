package com.wl.applictaion;

import io.dropwizard.Configuration;

/**
 * Created by wl on 16-8-15.
 */
public class MyConfig extends Configuration{

    private String startModule;

    public String getStartModule() {
        return startModule;
    }

    public void setStartModule(String startModule) {
        this.startModule = startModule;
    }
}
