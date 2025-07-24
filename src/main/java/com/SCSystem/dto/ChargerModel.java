package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChargerModel {
	private int idx;
	private int company_idx;
	private String name;
	private String code;
	private String vendor;
	private String speed;
	private String connector_type;
	private int connector_number;
	private String create_dt;
	private String modify_dt;
}
