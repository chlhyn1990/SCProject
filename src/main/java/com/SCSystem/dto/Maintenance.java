package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Maintenance {
	private int idx;
	private int check_mst_idx;
	
	private String contact;		//고장시 비상연락처
	private String organize;	//주위 정리정돈
	private String ascenter;	//AS센터 연결가능
	private String complaint;	//불편민원신고센터 연결가능
	private String light;		//고장시 표시등
	
	private String modify_dt;
	private String create_dt;
}