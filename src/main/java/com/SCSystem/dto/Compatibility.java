package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Compatibility {
	private int idx;
	private int check_mst_idx;
	
	private String open;		//개방 여부
	private String access;		//쉽게  접근가능
	private String milestone;	//이정표  설치  여부
	private String rapid;		//(완속,급속) 표시
	private String space;		//적정공간 확보
	private String free;		//무료주차
	
	private String modify_dt;
	private String create_dt;
}