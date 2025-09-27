package com.SCSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class FileUploadController {
    // 절대경로 (리눅스 예시)
    private static final String UPLOAD_BASE_DIR = "/home/as_evse/uploads/";

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("folder") String folder,
            @RequestParam("filename") String filename,
            @RequestParam("distributionIdx") String distributionIdx
            ) {

        try {
            // 저장할 폴더 경로 (절대경로)
            File directory = new File(UPLOAD_BASE_DIR + folder);
            if (!directory.exists()) {
                directory.mkdirs(); // 폴더 없으면 생성
            }

            // 저장할 파일 객체 생성
            File dest = new File(directory, filename);

            // 파일 저장
            file.transferTo(dest);

            return ResponseEntity.ok("업로드 성공: " + dest.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("업로드 실패: " + e.getMessage());
        }
    }
}
