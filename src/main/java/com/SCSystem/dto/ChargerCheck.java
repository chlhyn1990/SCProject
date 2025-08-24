package com.SCSystem.dto;

import lombok.Data;

@Data
public class ChargerCheck {
    private Integer idx;
    private Integer chargerIdx;
    private Integer chargerStationIdx;
    private Integer distributionIdx;
    private Integer managerIdx;
    private Integer checkListIdx;
    private String value;
    private String valueType;   // 1:사진, 2:YN, 3:측정값
    private String photoUrl;
    private String photoPath;
    private String createDt;    // VARCHAR(45)라서 String으로 처리
    private String modifyDt;
}
