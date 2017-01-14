package com.flyingrain.projectgenerator.projectmodel;

/**
 * Created by wulei on 17-1-14.
 */
public class ProjectModel {

    private String name;

    private PackageModel root;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PackageModel getRoot() {
        return root;
    }

    public void setRoot(PackageModel root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "ProjectModel{" +
                "name='" + name + '\'' +
                ", root=" + root +
                '}';
    }
}
