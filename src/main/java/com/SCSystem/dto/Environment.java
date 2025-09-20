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
	
	private String facilities;
	private String rainwater;
	private String contact;
	private String danger;
	private String locking;
	private String wire;
	private String meter;
	private String gate;
	private String grounding_work;
	private String resistance;
	private String thickness;
	private String distribution;
	private String cable;
	private String wiring;
	private String suitable_cable;
	private String metal_part;
	private String cable_damage;
	private String wiring_status;
	private String insulation_resistance;
	private String type_charger1;
	private String type_charger2;
	private String gate_value;
	private String overcurrentW;
	private String overcurrentA;
	private String leakageW;
	private String leakageA;
	private String sensitivity;
	private String wire_thickness;
	private String cable_tightening;
	
	private String modify_dt;
	private String create_dt;
}