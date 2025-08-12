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
	final static public String MANAGER_UPDATE_FAIL = "2002";
	final static public String MANAGER_DELETE_FAIL = "2003";
	final static public String MANAGER_INSERT_FAIL_MSG = "매니저 가입 실패";
	final static public String MANAGER_UPDATE_FAIL_MSG = "매니저 수정 실패";
	final static public String MANAGER_DELETE_FAIL_MSG = "매니저 삭제 실패";
	
	//COMPANY
	final static public String COMPANY_INSERT_FAIL = "3001";
	final static public String COMPANY_UPDATE_FAIL = "3002";
	final static public String COMPANY_DELETE_FAIL = "3003";
	final static public String COMPANY_INSERT_FAIL_MSG = "회사 등록 실패";
	final static public String COMPANY_UPDATE_FAIL_MSG = "회사 수정 실패";
	final static public String COMPANY_DELETE_FAIL_MSG = "회사 삭제 실패";
	
	public String code;
	public String msg;
}