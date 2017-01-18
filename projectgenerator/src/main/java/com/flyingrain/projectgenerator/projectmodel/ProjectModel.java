package com.flyingrain.projectgenerator.projectmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wulei on 17-1-14.
 */
public class ProjectModel {

    private String id;

    private String name;

    private PackageModel conf;

    private List<PackageModel> modules;

    private FileModel gitignore;

    private FileModel pom;

    private ConcurrentHashMap container;

    public ProjectModel(String name, PackageModel conf, FileModel gitignore, FileModel pom) {
        this.name = name;
        this.conf = conf;
        this.gitignore = gitignore;
        this.pom = pom;
        modules = new ArrayList<PackageModel>();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addMoudle(PackageModel moudle){
        this.modules.add(moudle);
    }



    @Override
    public String toString() {
        return "ProjectModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", conf=" + conf +
                ", gitignore=" + gitignore +
                ", pom=" + pom +
                '}';
    }
}
