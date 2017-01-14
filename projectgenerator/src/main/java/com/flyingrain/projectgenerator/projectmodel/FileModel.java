package com.flyingrain.projectgenerator.projectmodel;

/**
 * Created by wulei on 17-1-14.
 */
public class FileModel {

    private String name;

    private String type;

    private String content;

    private PackageModel packageModel;

    public FileModel(String name, String type, PackageModel packageModel) {
        this.name = name;
        this.type = type;
        this.packageModel = packageModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PackageModel getPackageModel() {
        return packageModel;
    }

    public void setPackageModel(PackageModel packageModel) {
        this.packageModel = packageModel;
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", packageModel=" + packageModel +
                '}';
    }
}
