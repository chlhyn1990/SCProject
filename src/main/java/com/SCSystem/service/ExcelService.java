package com.SCSystem.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ExcelService {

    /**
     * 템플릿 파일을 로드하여 동일한 엑셀을 메모리에 생성한 뒤 byte 배열로 반환합니다.
     */
    public byte[] createInspectionForm(int check_mst_idx) throws IOException {
        InputStream templateStream = null;
        
        try {
            // 1) 먼저 절대경로 파일 시도
            File templateFile = new File("C:\\dev\\project\\1sheet.xlsx");
            if (templateFile.exists() && templateFile.isFile()) {
                templateStream = new FileInputStream(templateFile);
            } 
            // 2) 클래스패스 리소스 시도
            else {
                templateStream = this.getClass().getClassLoader().getResourceAsStream("1sheet.xlsx");
                if (templateStream == null) {
                    throw new FileNotFoundException("템플릿 파일을 찾을 수 없습니다. "
                            + "C:\\dev\\project\\1sheet.xlsx 또는 클래스패스의 1sheet.xlsx 위치를 확인하세요.");
                }
            }

            // Workbook 생성 및 처리
            try (Workbook workbook = new XSSFWorkbook(templateStream);
                 ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                
                // 필요시 플레이스홀더 치환 활성화
                // replacePlaceholders(workbook, check_mst_idx);
                
                workbook.write(outputStream);
                return outputStream.toByteArray();
            }
            
        } finally {
            // templateStream 명시적으로 닫기
            if (templateStream != null) {
                try {
                    templateStream.close();
                } catch (IOException e) {
                    // 닫기 실패는 무시
                }
            }
        }
    }
}