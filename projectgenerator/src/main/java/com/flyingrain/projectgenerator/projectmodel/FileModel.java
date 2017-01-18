package com.flyingrain.projectgenerator.projectmodel;

/**
 * Created by wulei on 17-1-14.
 */
public class FileModel {
    /**
     * 文件Id,在项目立唯一
     */
    private  String id;

    private String name;

    private String type;

    private String content;

    private PackageModel parent;

    public FileModel(String name, String type, PackageModel parent) {
        this.name = name;
        this.type = type;
        this.parent = parent;
    }

    public FileModel(String id, String name, String type, PackageModel parent) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.parent = parent;
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
        return parent;
    }

    public void setPackageModel(PackageModel packageModel) {
        this.parent = packageModel;
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", packageModel=" + parent +
                '}';
    }
}
