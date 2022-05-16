package com.example.hello.fileManager.service;

import com.example.hello.Common.ApiResponse;
import com.example.hello.fileManager.entity.UploadFileCreatePayload;
import com.example.hello.fileManager.entity.UploadFileUpdatePayload;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    ApiResponse list();
    ApiResponse detail(int id);
    ApiResponse create(UploadFileCreatePayload payload);
    ApiResponse update(UploadFileUpdatePayload payload);
    ApiResponse upload(MultipartFile file);
    ApiResponse delete(int id);
}
