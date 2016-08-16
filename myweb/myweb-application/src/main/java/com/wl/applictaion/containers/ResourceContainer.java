package com.wl.applictaion.containers;

/**
 * Created by wul on 2016/8/16.
 */

import com.wl.myweb.api.Resource;

import java.util.ArrayList;
import java.util.List;

public class ResourceContainer {
    private List<Resource> resources = new ArrayList<Resource>();

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
