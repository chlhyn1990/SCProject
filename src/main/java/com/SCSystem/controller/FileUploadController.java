package com.SCSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequestMapping("/app/api")
@RestController
public class FileUploadController {
    private static final String UPLOAD_BASE_DIR = "/home/as_evse/uploads/";

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("folder") String folder,
            @RequestParam("filename") String filename,
            @RequestParam("distributionIdx") String distributionIdx // 이 파라미터도 클라이언트에서 보낼 것
    ) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("업로드할 파일이 없습니다.");
        }

        try {
            // 저장할 폴더 경로 (절대경로)
            File directory = new File(UPLOAD_BASE_DIR + folder);
            if (!directory.exists()) {
                if (!directory.mkdirs()) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("폴더 생성 실패: " + directory.getAbsolutePath());
                }
            }

            // 저장할 파일 객체 생성
            File dest = new File(directory, filename);

            // 파일 저장
            file.transferTo(dest);

            return ResponseEntity.ok("업로드 성공: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("업로드 실패: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("업로드 실패: " + e.getMessage());
        }
    }
}
