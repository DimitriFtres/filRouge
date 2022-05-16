package com.example.hello.fileManager.controller;

import com.example.hello.Common.ApiResponse;
import com.example.hello.fileManager.entity.UploadFileCreatePayload;
import com.example.hello.fileManager.entity.UploadFileUpdatePayload;
import com.example.hello.fileManager.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("file")
public class FileController {
    @Autowired
    FileService fileService;

    @GetMapping("/list")
    public ApiResponse list() {
        return fileService.list();
    }

    @GetMapping("/detail/{id}")
    public ApiResponse detail(@PathVariable("id") int id) {
        return fileService.detail(id);
    }

    @PostMapping("/create")
    public ApiResponse create(@RequestBody UploadFileCreatePayload payload) {
        return fileService.create(payload);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody UploadFileUpdatePayload payload) {
        return fileService.update(payload);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable("id") int id) {
        return fileService.delete(id);
    }

    @PostMapping("/upload")
    public ApiResponse handleFileUpload(@RequestParam("file") MultipartFile file) {
        return fileService.upload(file);
    }
}
