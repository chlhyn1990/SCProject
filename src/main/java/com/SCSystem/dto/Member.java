package com.SCSystem.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	private int idx; 			
	private String id; 		
	private String pw; 	
	private String user_name;
}

