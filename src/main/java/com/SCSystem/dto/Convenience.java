package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Convenience {
	private int idx;
	private int check_mst_idx;
	
	private String homepage;
	private String facility;
	private String status;
	private String stopper;
	private String screen;
	private String payment;
	private String lighting;
	private String cctv;
	private String emergency;
	private String card;
	private String traffic;
	
	private String modify_dt;
	private String create_dt;
}