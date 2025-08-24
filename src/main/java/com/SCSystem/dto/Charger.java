package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Charger {
	private int idx;
	private int charger_station_idx;
	private int charger_model_idx;
	private int distribution_idx;
	private String station_name;
	private String model_name;
	private String charger_id;
	private String me_id;
	private String detail_place;
	private String broken_part;
	private String remark;
	private String fixed_dt;
	private int manager_idx;
	private String manager_name;
	private String modify_dt;
	private String create_dt;
}
