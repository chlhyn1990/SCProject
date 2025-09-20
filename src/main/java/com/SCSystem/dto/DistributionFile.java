package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DistributionFile {
	private int idx;
	private int check_mst_idx;
	private int distribution_idx;
	
	private String foreground_url;	//충전소 전경(충전기 및 주위 전경)
	private String foreground_path;	//충전소 전경(충전기 및 주위 전경)
	private String external_url;	//분전반 외부
	private String external_path;	//분전반 외부
	private String internal_url;	//분전반 내부
	private String internal_path;	//분전반 내부
	private String mccb_url;		//MCCB
	private String mccb_path;		//MCCB
	private String resistance_url;	//분전반 접지저항
	private String resistance_path;	//분전반 접지저항
	private String wire_status_url;	//결선상태 (분전반 내부 근접샷)
	private String wire_status_path;//결선상태 (분전반 내부 근접샷)
	private String meter_url;		//계량기
	private String meter_path;		//계량기
	private String meter_text;		//계량기 번호
	private String modem_front_url;	//모뎀 앞면
	private String modem_front_path;//모뎀 앞면
	private String modem_front_text;//모뎀 앞면 회사
	private String modem_back_url;	//모뎀 뒷면
	private String modem_back_path;	//모뎀 뒷면
	private String modem_back_text;	//모뎀 뒷면 번호
	private String bollard_url;		//기타, 볼라드/스토퍼 정상설치 여부
	private String bollard_path;	//기타, 볼라드/스토퍼 정상설치 여부
	private String etc_url;			//기타, 연결볼트 정상 여부
	private String etc_path;		//기타, 연결볼트 정상 여부
	
	private String modify_dt;
	private String create_dt;
}