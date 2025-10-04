package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductSafety {
	private int idx;
	private int check_mst_idx;
	
	private String rust;		//발청,누수,녹발생 없음
	private String stopper;		//볼라드/스토퍼 고정
	private String connector;	//커넥터균열,파손없음
	private String lock;		//보호잠금장치 정상
	private String discolor;	//충전기 변색 없음
	private String pad;			//충전기패드 정상고정
	
	private String modify_dt;
	private String create_dt;
}