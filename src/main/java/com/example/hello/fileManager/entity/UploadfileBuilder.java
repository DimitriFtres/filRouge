package com.example.hello.fileManager.entity;

public class UploadfileBuilder {
    private String name;
    private String type;
    private String path;
    private boolean deleted;

    public UploadfileBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UploadfileBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public UploadfileBuilder setPath(String path) {
        this.path = path;
        return this;
    }

    public UploadfileBuilder setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }
    public UploadFile build(){
        return new UploadFile(name,type, path,deleted);
    }
}
