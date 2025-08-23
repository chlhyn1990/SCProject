package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChargerStation {
	private int idx;
	private int company_idx;
	private int manager_idx;
	private String company_name;
	private String manager_name;
	private String name;
	private String chargerCompany;
	private String station_id;
	private String addr;
	private String detail_addr;
	private String sido;
	private String sigungu;
	private double latitude;
	private double longitude;
	private int volt;
	private int watt;
	private String chargerType;
	private String result;
	private String create_dt;
	private String modify_dt;
}
