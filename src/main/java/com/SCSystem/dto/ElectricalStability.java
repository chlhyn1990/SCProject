package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ElectricalStability {
	private int idx;
	private int check_mst_idx;
	
	private String facilities;				//시설의 적정성
	private String rainwater;				//빗물등에 안전
	private String contact;					//사람 접촉에 안전
	private String danger;					//위험표지 여부
	private String locking;					//분전함 LOCKING
	private String wire;					//분전함 접지선
	private String meter;					//계량기 점검 용이
	private String gate;					//차단기 정상동작
	private String grounding_work;			//접지공사 적정성
	private String resistance;				//접지저항값
	private String thickness;				//접지선의 굵기
	private String distribution;			//분전반, 충전기 외함
	private String cable;					//충전기 케이블
	private String wiring;					//배선의 적정성
	private String suitable_cable;			//적합한 케이블 사용
	private String metal_part;				//금속부분은 접지
	private String cable_damage;			//케이블의 손상 없음
	private String wiring_status;			//분전함 결선상태 정상
	private String insulation_resistance;	//절연 저항 측정
	private String type_charger1;			//• 1종충전기 : 1㏁ 이상
	private String type_charger2;			//• 2종충전기 : 7㏁ 이상
	private String gate_value;				//차단기 적정성
	private String overcurrentW;			//과전류차단기정격
	private String overcurrentA;			//과전류차단기정격
	private String leakageW;				//누전차단기정격
	private String leakageA;				//누전차단기정격
	private String sensitivity;				//감도전류/동작시간
	private String wire_thickness;			//전선의 굵기
	private String cable_tightening;		//케이블 조임상태 정상
	
	private String modify_dt;
	private String create_dt;
}