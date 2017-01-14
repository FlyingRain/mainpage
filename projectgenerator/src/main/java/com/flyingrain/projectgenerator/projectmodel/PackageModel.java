package com.flyingrain.projectgenerator.projectmodel;

import java.util.List;

/**
 * Created by wulei on 17-1-14.
 */
public class PackageModel {

    private String id;

    private String name;

    private PackageModel parent;

    private List<PackageModel> childernPackages;

    private List<FileModel> childernFiles;

    public PackageModel(String name, PackageModel parent, List<PackageModel> childernPackages, List<FileModel> childernFiles) {
        this.name = name;
        this.parent = parent;
        this.childernPackages = childernPackages;
        this.childernFiles = childernFiles;
    }

    public PackageModel(String id, String name, PackageModel parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PackageModel getParent() {
        return parent;
    }

    public void setParent(PackageModel parent) {
        this.parent = parent;
    }

    public List<PackageModel> getChildernPackages() {
        return childernPackages;
    }

    public void setChildernPackages(List<PackageModel> childernPackages) {
        this.childernPackages = childernPackages;
    }

    public List<FileModel> getChildernFiles() {
        return childernFiles;
    }

    public void setChildernFiles(List<FileModel> childernFiles) {
        this.childernFiles = childernFiles;
    }

    @Override
    public String toString() {
        return "PackageModel{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                ", childernPackages=" + childernPackages +
                ", childernFiles=" + childernFiles +
                '}';
    }
}
