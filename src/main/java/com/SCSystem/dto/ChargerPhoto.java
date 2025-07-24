package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChargerPhoto {
	private int idx;
	private int charger_idx;
	private int manager_idx;
	private int check_list_idx;
	private String photo_type;
	private String photo_url;
	private String photo_path;
	private String create_dt;
	private String modify_dt;
}
