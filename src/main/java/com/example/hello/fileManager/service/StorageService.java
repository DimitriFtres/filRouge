package com.example.hello.fileManager.service;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
    public void init();
    public boolean save(MultipartFile file);
    public Resource load(String filename);
    public void deleteAll();
    public Stream<Path> loadAll();
}
