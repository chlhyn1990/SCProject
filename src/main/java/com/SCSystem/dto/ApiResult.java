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
	final static public String SQL_ERROR = "1001";
	final static public String SERVER_ERROR = "1002";
	final static public String ETC = "1005";
	
	final static public String SUCCESS_MSG = "성공";
	final static public String SQL_ERROR_MSG = "데이터 처리 오류";
	final static public String SERVER_ERROR_MSG = "서버 측 오류";
	final static public String ETC_MSG = "기타오류";
	
	final static public String COMMON_SELECT_FAIL = "2000";
	final static public String COMMON_INSERT_FAIL = "2001";
	final static public String COMMON_UPDATE_FAIL = "2002";
	final static public String COMMON_DELETE_FAIL = "2003";
	final static public String COMMON_SELECT_FAIL_MSG = "조회 실패";
	final static public String COMMON_INSERT_FAIL_MSG = "등록 실패";
	final static public String COMMON_UPDATE_FAIL_MSG = "수정 실패";
	final static public String COMMON_DELETE_FAIL_MSG = "삭제 실패";
	
	public String code;
	public String msg;
}