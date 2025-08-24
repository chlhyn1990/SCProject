package com.SCSystem.dto;

import lombok.Data;
import org.apache.ibatis.cache.Cache;

import java.util.Calendar;

@Data
public class Distribution {
    private Integer idx;
    private Integer chargerStationIdx;
    private String id;
    private String name;
    private String detailPlace;
    private String createDt;
    private String modifyDt;
}
