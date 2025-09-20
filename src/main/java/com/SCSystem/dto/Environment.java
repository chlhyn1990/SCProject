package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Environment {
	private int idx;
	private int check_mst_idx;
	
	private String temperature;	//주위온도  적정성 (옥내:-5℃ ~ +40℃,옥외:-25℃ ~ +40℃)
	private String gas;			//분진,가스등에  안전
	private String openness;	//발열대비  개방성
	private String slip;		//미끄럼방지  여부
	private String ventilation;	//환기  적정성
	private String snowrain;	//눈,비에  안전
	private String flooding;	//침수방지  등
	private String vibration;	//진동,발열체에  안전
	
	private String modify_dt;
	private String create_dt;
}