package com.SCSystem.dto;

import lombok.Data;

@Data
public class ChargerCheck {
    private Integer idx;
    private Integer charger_idx;
    private Integer charger_station_idx;
    private Integer distribution_idx;
    private Integer manager_idx;
    private Integer check_list_idx;
    private String value;
    private String value_type;   // 1:사진, 2:YN, 3:측정값
    private String photo_url;
    private String photo_path;
    private String create_dt;    // VARCHAR(45)라서 String으로 처리
    private String modify_dt;
}
