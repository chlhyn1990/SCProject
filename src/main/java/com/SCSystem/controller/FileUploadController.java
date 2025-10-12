package com.SCSystem.controller;

import com.SCSystem.service.AppService;
import com.SCSystem.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping("/app/api")
@Slf4j
@RestController
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("/upload/distribution_file")
    public ResponseEntity<String> handleDistributionFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("data") String data
    ) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("업로드할 파일이 없습니다.");
        }

        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(data);
            JSONObject jsonObj = (JSONObject) obj;

            long jsonDistributionIdx = (Long) jsonObj.get("distributionIdx");
            int distributionIdx = (int) jsonDistributionIdx;

            Integer fileUploadResult = fileUploadService.makeFile(distributionIdx, (String) jsonObj.get("filename"), file);
            if(fileUploadResult<0){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("[handleDistributionFileUpload]"+data+" 업로드 실패!");
            }

            Integer insertResult = fileUploadService.insertDistributionFiles(distributionIdx,(String) jsonObj.get("filename"), (String) jsonObj.get("text"));

            if(insertResult<0){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("[handleDistributionFileUpload] "+data+" DB 저장 실패!");
            }
            return ResponseEntity.ok("[handleDistributionFileUpload]"+data+" 업로드 성공!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("[handleDistributionFileUpload] "+data +" 업로드 에러: " + e.getMessage());
        }
    }

    @PostMapping("/upload/charger_file")
    public ResponseEntity<String> handleChargerFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("data") String data
    ) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("업로드할 파일이 없습니다.");
        }

        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(data);
            JSONObject jsonObj = (JSONObject) obj;

            long jsonDistributionIdx = (Long) jsonObj.get("distributionIdx");
            int distributionIdx = (int) jsonDistributionIdx;
            long jsonChargerIdx = (Long) jsonObj.get("chargerIdx");
            int chargerIdx = (int) jsonChargerIdx;

            Integer fileUploadResult = fileUploadService.makeFile(distributionIdx, chargerIdx,(String) jsonObj.get("filename"), file);
            if(fileUploadResult<0){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("[handleChargerFileUpload] "+data+" 업로드 실패!");
            }

            Integer insertResult = fileUploadService.updateChargerFile(distributionIdx,chargerIdx,(String) jsonObj.get("filename"), (String) jsonObj.get("text"));

            if(insertResult<0){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("[FileUploadController] DB 저장 실패!");
            }
            return ResponseEntity.ok("[handleChargerFileUpload] "+data+" 업로드 성공!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("[handleChargerFileUpload] 업로드 에러: "+data+" "+e.getMessage());
        }
    }

}
