package com.SCSystem.dto;

import lombok.Data;
import org.apache.ibatis.cache.Cache;

import java.util.Calendar;

@Data
public class Distribution {
    private Integer idx;
    private Integer charger_station_idx;
    private String id;
    private String name;
    private String detail_place;
    private String create_dt;
    private String modify_dt;
}
