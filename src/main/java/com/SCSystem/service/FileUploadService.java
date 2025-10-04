package com.SCSystem.service;

import com.SCSystem.mapper.AppCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadService {
    @Autowired
    AppCheckMapper appCheckMapper;

    final static String ftpURL = "ftp://MSI_PC:1234@192.168.55.34/";
    final static String localPath = "/home/as_evse/photos/";

    public int insertDistributionFiles(Integer distributionIdx, String filename, String text){
        String stationId = appCheckMapper.getStationIdByDistributionIdx(distributionIdx);
        Integer checkMstIdx = appCheckMapper.getCheckMstdxByDistributionIdx(distributionIdx);
        switch (filename){
            case "foreground":
                appCheckMapper.insertDistributionForeground(checkMstIdx, distributionIdx, ftpURL+stationId+"/distribution/"+filename,localPath+stationId+"distribution/"+filename);
                break;

            case "external":
                appCheckMapper.insertDistributionExternal(checkMstIdx, distributionIdx, ftpURL+stationId+"/distribution/"+filename,localPath+stationId+"distribution/"+filename);
                break;

            case "internal":
                appCheckMapper.insertDistributionInternal(checkMstIdx, distributionIdx, ftpURL+stationId+"/distribution/"+filename,localPath+stationId+"distribution/"+filename);
                break;

            case "mccb":
                appCheckMapper.insertDistributionMccb(checkMstIdx, distributionIdx, ftpURL+stationId+"/distribution/"+filename,localPath+stationId+"distribution/"+filename);
                break;

            case "resistance":
                appCheckMapper.insertDistributionResistance(checkMstIdx, distributionIdx, ftpURL+stationId+"/distribution/"+filename,localPath+stationId+"distribution/"+filename);
                break;

            case "wire_status":
                appCheckMapper.insertDistributionWireStatus(checkMstIdx, distributionIdx, ftpURL+stationId+"/distribution/"+filename,localPath+stationId+"distribution/"+filename);
                break;

            case "meter":
                appCheckMapper.insertDistributionMeter(checkMstIdx, distributionIdx, ftpURL+stationId+"/distribution/"+filename,localPath+stationId+"distribution/"+filename, text);
                break;

            case "modem_front":
                appCheckMapper.insertDistributionModemFront(checkMstIdx, distributionIdx, ftpURL+stationId+"/distribution/"+filename,localPath+stationId+"distribution/"+filename, text);
                break;

            case "modem_back":
                appCheckMapper.insertDistributionModemBack(checkMstIdx, distributionIdx, ftpURL+stationId+"/distribution/"+filename,localPath+stationId+"distribution/"+filename, text);
                break;

            case "bollard":
                appCheckMapper.insertDistributionBollard(checkMstIdx, distributionIdx, ftpURL+stationId+"/distribution/"+filename,localPath+stationId+"distribution/"+filename);
                break;
            case "etc":
                appCheckMapper.insertDistributionEtc(checkMstIdx, distributionIdx, ftpURL+stationId+"/distribution/"+filename,localPath+stationId+"distribution/"+filename);
                break;


        }

        return 1;
    }
}
