package com.example.hello.fileManager.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class StorageServiceImpl implements StorageService {
    private final Path root = Paths.get("upload");

    @Override
    public void init() {
        try {
            Files.createDirectory(root);
            System.out.println("[FILE MANAGER] Root folder created successfully : "+root.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("[FILE MANAGER] Folder already exists : "+root.toAbsolutePath());
            // throw new RuntimeException("[FILE MANAGER] Could not initialize folder for upload!");
        }
    }

    @Override
    public boolean save(MultipartFile file) {
        try {
            this.init();
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("[FILE MANAGER] Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("[FILE MANAGER] Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("[FILE MANAGER] Could not load the files!");
        }
    }
}
