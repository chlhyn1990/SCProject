package com.SCSystem.dto;

import lombok.Data;
import org.apache.ibatis.cache.Cache;

import java.util.Calendar;
import java.util.List;

@Data
public class Distribution {
    private Integer idx;
    private Integer charger_station_idx;
    private String id;
    private String name;
    private String place1;
    private String place2;
    private String place3;
    private int volt;
    private int watt;
    private String stand_type;
    private String move_type;
    private String wall_type;
    private String etc_type;
    private String screen;
    private String touch;
    private String communicate;
    private String card;
    private String charge;
    private String gate;
    private String power;
    private String err;
    private String connector;
    private String etc;
    private String create_dt;
    private String modify_dt;
    private List<Charger> chargerList;
    
	private Integer company_idx;
	private Integer manager_idx;
	
	private String station_name;
	private String manager_name;
	private String check_dt;
}
