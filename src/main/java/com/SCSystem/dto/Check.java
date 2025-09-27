package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Check {
	private CheckMst checkMst;
	private Compatibility compatibility; 	//적합성
	private Environment environment;		//환경성
	private Convenience convenience;		//편리성
	private ProductSafety productSafety; //제품안정성
	private ElectricalStability electricalStability; //전기안정성 
	private FireSafety fireSafety; //소방안정성
	private Maintenance maintenance; //유지보수
	private ChargingOperation chargingOperation; //충전작동
	private Opinion opinion; //종합의견
}