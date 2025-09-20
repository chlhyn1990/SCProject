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
	
	private String homepage;	//홈페이지 (누리집) 연동여부
	private String facility;	//충전시설  위치
	private String status;		//상태정보  확인
	private String stopper;		//스토퍼,볼라드  등
	private String screen;		//터치스크린  정상여부
	private String payment;		//환경부카드 외 결재방식
	private String lighting;	//적정  조명 (기준조도:40lx)
	private String cctv;		//CCTV (관리원)
	private String emergency;	//비상정지버튼
	private String card;		//환경부카드  사용가능
	private String traffic;		//차량,보행자 통행안전
	
	private String modify_dt;
	private String create_dt;
}