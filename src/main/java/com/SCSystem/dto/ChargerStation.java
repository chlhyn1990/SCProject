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
	private String name;
	private String station_id;
	private String addr;
	private String detail_addr;
	private float latitude;
	private float longitude;
	private String create_dt;
	private String modify_dt;
}
