package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DistributionFile {
	private int idx;
	private int check_mst_idx;
	private int distribution_idx;
	
	private String foreground_url;
	private String foreground_path;
	private String external_url;
	private String external_path;
	private String internal_url;
	private String internal_path;
	private String mccb_url;
	private String mccb_path;
	private String resistance_url;
	private String resistance_path;
	private String wire_status_url;
	private String wire_status_path;
	private String meter_url;
	private String meter_path;
	private String meter_text;
	private String modem_front_url;
	private String modem_front_path;
	private String modem_front_text;
	private String modem_back_url;
	private String modem_back_path;
	private String modem_back_text;
	private String bollard_url;
	private String bollard_path;
	private String etc_url;
	private String etc_path;
	
	private String modify_dt;
	private String create_dt;
}