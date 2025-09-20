package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChargerFile {
	private int idx;
	private int check_mst_idx;
	private int charger_idx;
	
	private String test_url;		//충전테스트(충전기에 부착된 모든 스티커 확인 필요)
	private String test_path;		//충전테스트(충전기에 부착된 모든 스티커 확인 필요)
	private String plate_url;		//명판
	private String plate_path;		//명판
	private String resistance_url;	//절연저항
	private String resistance_path;	//절연저항
	private String info_url;		//안내문/캐노피측면
	private String info_path;		//안내문/캐노피측면
	private String bollard_url;		//볼라드/스토퍼
	private String bollard_path;	//볼라드/스토퍼
	private String connector_url;	//커넥터
	private String connector_path;	//커넥터
	
	private String modify_dt;
	private String create_dt;
}