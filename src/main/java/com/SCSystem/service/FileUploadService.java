package com.SCSystem.service;

import com.SCSystem.mapper.AppCheckMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class FileUploadService {
    @Autowired
    AppCheckMapper appCheckMapper;

    private final static String FTP_URL = "ftp://MSI_PC:1234@192.168.55.34/";
//  private final static String LOCAL_PATH = "/home/as_evse/uploads/";
    private static final String LOCAL_PATH = "F:\\upload/";
    private Integer stationIdx;
    public Integer insertDistributionFiles(Integer distributionIdx, String filename, String text){
        Integer checkMstIdx = appCheckMapper.getCheckMstIdxByDistributionIdx(distributionIdx);
        Integer result;
        switch (filename){
            case "foreground.jpg":
                result = appCheckMapper.insertDistributionForeground(checkMstIdx, distributionIdx, FTP_URL + stationIdx +"/"+distributionIdx+"/"+filename, LOCAL_PATH + stationIdx +distributionIdx+filename);
                break;

            case "external.jpg":
                result = appCheckMapper.insertDistributionExternal(checkMstIdx, distributionIdx, FTP_URL + stationIdx +"/"+distributionIdx+"/"+filename, LOCAL_PATH + stationIdx +distributionIdx+filename);
                break;

            case "internal.jpg":
                result = appCheckMapper.insertDistributionInternal(checkMstIdx, distributionIdx, FTP_URL + stationIdx +"/"+distributionIdx+"/"+filename, LOCAL_PATH + stationIdx +distributionIdx+filename);
                break;

            case "mccb.jpg":
                result = appCheckMapper.insertDistributionMccb(checkMstIdx, distributionIdx, FTP_URL + stationIdx +"/"+distributionIdx+"/"+filename, LOCAL_PATH + stationIdx +distributionIdx+filename);
                break;

            case "resistance.jpg":
                result = appCheckMapper.insertDistributionResistance(checkMstIdx, distributionIdx, FTP_URL + stationIdx +"/"+distributionIdx+"/"+filename, LOCAL_PATH + stationIdx +distributionIdx+filename);
                break;

            case "wire_status.jpg":
                result = appCheckMapper.insertDistributionWireStatus(checkMstIdx, distributionIdx, FTP_URL + stationIdx +"/"+distributionIdx+"/"+filename, LOCAL_PATH + stationIdx +distributionIdx+filename);
                break;

            case "meter.jpg":
                result = appCheckMapper.insertDistributionMeter(checkMstIdx, distributionIdx, FTP_URL + stationIdx +"/"+distributionIdx+"/"+filename, LOCAL_PATH + stationIdx +distributionIdx+filename, text);
                break;

            case "modem_front.jpg":
                result = appCheckMapper.insertDistributionModemFront(checkMstIdx, distributionIdx, FTP_URL + stationIdx +"/"+distributionIdx+"/"+filename, LOCAL_PATH + stationIdx +distributionIdx+filename, text);
                break;

            case "modem_back.jpg":
                result = appCheckMapper.insertDistributionModemBack(checkMstIdx, distributionIdx, FTP_URL + stationIdx +"/"+distributionIdx+"/"+filename, LOCAL_PATH + stationIdx +distributionIdx+filename, text);
                break;

            case "bollard.jpg":
                result = appCheckMapper.insertDistributionBollard(checkMstIdx, distributionIdx, FTP_URL + stationIdx +"/"+distributionIdx+"/"+filename, LOCAL_PATH + stationIdx +distributionIdx+filename);
                break;
            case "etc.jpg":
                result = appCheckMapper.insertDistributionEtc(checkMstIdx, distributionIdx, FTP_URL + stationIdx +"/"+distributionIdx+"/"+filename, LOCAL_PATH + stationIdx +distributionIdx+filename);
                break;
            default:
                return -1;
        }
        return result;
    }

    public Integer makeFile(Integer distributionIdx, String filename, MultipartFile file){
        stationIdx = appCheckMapper.getStationIdxByDistributionIdx(distributionIdx);
        // 저장할 폴더 경로 (절대경로)
        File directory = new File(LOCAL_PATH + stationIdx +"\\"+distributionIdx);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                log.error("[FileUploadService] 폴더 생성 실패!: " + directory.getAbsolutePath());
                return -1;
            }
        }

        // 저장할 파일 객체 생성
        File dest = new File(directory, filename);

        // 파일 저장
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return 1;
    }
}
