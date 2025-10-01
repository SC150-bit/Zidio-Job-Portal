
package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "*")
public class FileController {
    @Autowired private FileStorageService fileStorage;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        String path = fileStorage.storeFile(file);
        return ResponseEntity.ok(Map.of("path", path));
    }
}
