package com.example.hello.fileManager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileCreatePayload {
    private String name;
    private String type;
    private String path;
    private boolean deleted;
}
