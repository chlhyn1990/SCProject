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
	private int dix;
	private int charger_station_idx;
	private int charger_model_idx;
	private String charger_id;
	private String me_id;
	private String detail_place;
	private String broken_part;
	private String remark;
	private String fixed_dt;
	private String manager_id;
	private String modify_dt;
	private String create_dt;
	private String chargercol;
}
