package com.wl.myweb.user.model;

/**
 * Created by wul on 2016/8/17.
 */
public class TestModel {

    private String name;

    private String say;

    public TestModel(String name, String say) {
        this.name = name;
        this.say = say;
    }

    public TestModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }
}
