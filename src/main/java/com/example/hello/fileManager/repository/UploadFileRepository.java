package com.example.hello.fileManager.repository;

import com.example.hello.fileManager.entity.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadFileRepository extends JpaRepository<UploadFile, Integer> {
}
