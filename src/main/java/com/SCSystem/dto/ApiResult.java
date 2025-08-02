package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResult {
	
	//COMMON
	final static public String SUCCESS = "0000";
	final static public String SERVER_ERROR = "1001";
	final static public String REQUIRED_VALUE_NULL = "1002";
	final static public String ETC = "1005";
	
	final static public String SUCCESS_MSG = "성공";
	final static public String SERVER_ERROR_MSG = "서버 측 오류입니다";
	final static public String REQUIRED_VALUE_NULL_MSG = "필수 값 누락되었습니다";
	final static public String ETC_MSG = "기타오류";
	
	//MANAGER
	final static public String MANAGER_INSERT_FAIL = "2001";
	final static public String MANAGER_INSERT_FAIL_MSG = "회원가입 실패";
	
	public String code;
	public String msg;
}