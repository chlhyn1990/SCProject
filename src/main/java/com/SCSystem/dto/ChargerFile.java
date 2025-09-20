package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChargerFile {
	private int idx;
	private int check_mst_idx;
	private int charger_idx;
	
	private String test_url;
	private String test_path;
	private String plate_url;
	private String plate_path;
	private String resistance_url;
	private String resistance_path;
	private String info_url;
	private String info_path;
	private String bollard_url;
	private String bollard_path;
	private String connector_url;
	private String connector_path;
	
	private String modify_dt;
	private String create_dt;
}