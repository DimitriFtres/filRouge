package com.example.hello.fileManager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileUpdatePayload {
    private int file_id;
    private String name;
    private String type;
    private String path;
    private boolean deleted;
}
