package com.example.hello.fileManager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UploadFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int file_id;
    private String name;
    private String type;
    private String path;
    private boolean deleted;

    public UploadFile(String name, String type, String path, boolean deleted) {

        this.name = name;
        this.type = type;
        this.path = path;
        this.deleted = deleted;
    }
}
