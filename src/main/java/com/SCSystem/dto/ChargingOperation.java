package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChargingOperation {
	private int idx;
	private int check_mst_idx;
	
	private String charge;	//차량 충전 작동
	private String speed;	//충전 속도 정상
	private String button;	//비상정지버튼 작동
	private String share;	//데이터 공유 적합성
	
	private String modify_dt;
	private String create_dt;
}