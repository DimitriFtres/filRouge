package com.example.hello.fileManager.service;

import com.example.hello.Common.ApiResponse;
import com.example.hello.fileManager.entity.UploadFile;
import com.example.hello.fileManager.entity.UploadFileCreatePayload;
import com.example.hello.fileManager.entity.UploadFileUpdatePayload;
import com.example.hello.fileManager.entity.UploadfileBuilder;
import com.example.hello.fileManager.repository.UploadFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    UploadFileRepository uploadFileRepository;
    @Autowired
    StorageService storageService;
    @Override
    public ApiResponse list() {
        try {
            return new ApiResponse(true, uploadFileRepository.findAll(), "api.file-upload.list.success");
        } catch (Exception e) {
            return new ApiResponse(false, null, "api.file-upload.list.error");
        }
    }

    @Override
    public ApiResponse detail(int id) {
        try {
            UploadFile file = uploadFileRepository.findById(id).orElse(null);
            if (file == null) {
                return new ApiResponse(false, null, "api.file-upload.detail-not-found");
            }
            return new ApiResponse(true, file, "api.file-upload.detail.success");
        } catch (Exception e) {
            return new ApiResponse(false, null, "api.file-upload.detail.error");
        }
    }

    @Override
    public ApiResponse create(UploadFileCreatePayload payload) {
        try {
            UploadFile file = uploadFileRepository.save(new UploadfileBuilder()
                    .setName(payload.getName())
                    .setDeleted(payload.isDeleted())
                    .setPath(payload.getPath())
                    .setType(payload.getType())
                    .build());
            return new ApiResponse(true, file, "api.file-upload.create.success");
        } catch (Exception e) {
            return new ApiResponse(false, null, "api.file-upload.create.error");
        }
    }

    @Override
    public ApiResponse upload(MultipartFile file) {
        if(storageService.save(file)){
            return new ApiResponse(true, null, "api.file-uplod.upload.success");
        }
        return new ApiResponse(false, null, "api.file-uplod.upload.error");
    }

    @Override
    public ApiResponse update(UploadFileUpdatePayload payload) {
        try {
            ApiResponse response = this.detail(payload.getFile_id());
            if (!response.isResult()) {
                return response;
            }
            UploadFile file = (UploadFile) response.getData();
            file.setName(payload.getName());
            file.setPath(payload.getPath());
            file.setType(payload.getType());
            file.setDeleted(payload.isDeleted());
            return new ApiResponse(true, uploadFileRepository.save(file), "api.file-upload.upload.success");
        } catch (Exception e) {
            return new ApiResponse(false, null, "api.file-upload.upload.error");
        }
    }

    @Override
    public ApiResponse delete(int id) {
        try {
            ApiResponse response = this.detail(id);
            if (!response.isResult()) {
                return response;
            }
            uploadFileRepository.delete((UploadFile) response.getData());
            return new ApiResponse(true, null, "api.file-upload.delete.success");
        } catch (Exception e) {
            return new ApiResponse(false, null, "api.file-upload.delete.error");
        }
    }
}
