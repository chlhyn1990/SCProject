package com.SCSystem.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import com.SCSystem.dto.ExcelData;

public class CheckListForm {
	ArrayList<ExcelData> list = new ArrayList<ExcelData>();
	
	public CheckListForm() {
		list.add(new ExcelData("점검일자", "", 1, 1));
		list.add(new ExcelData("주변 온도/습도", "", 1, 1));
		list.add(new ExcelData("점검자", "", 1, 1));
		
		list.add(new ExcelData("적합성", "title", 0, 0));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("개방 여부", "Y", 1, 1));
		list.add(new ExcelData("쉽게 접근가능", "Y", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("이정표 설치 여부", "Y", 1, 1));
		list.add(new ExcelData("(완속,급속) 표시", "Y", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("적정공간 확보", "Y", 1, 1));
		list.add(new ExcelData("무료주차", "Y", 1, 1));
		
		list.add(new ExcelData("환경성", "title", 0, 0));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("주위온도  적정성(옥내:-5℃ ~ +40℃,옥외:-25℃ ~ +40℃)", "Y", 1, 1));
		list.add(new ExcelData("분진,가스등에  안전", "Y", 1, 1));
		list.add(new ExcelData("발열대비  개방성", "Y", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("미끄럼방지  여부", "Y", 1, 1));
		list.add(new ExcelData("환기 적정성", "Y", 1, 1));
		list.add(new ExcelData("눈,비에 안전", "Y", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("침수방지 등", "Y", 1, 1));
		list.add(new ExcelData("진동,발열체에 안전", "Y", 1, 1));
		list.add(new ExcelData("", "", 1, 1));
		
		list.add(new ExcelData("편리성", "title", 0, 0));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("홈페이지 (누리집) 연동여부", "Y", 1, 1));
		list.add(new ExcelData("충전시설 위치", "Y", 1, 1));
		list.add(new ExcelData("상태정보 확인", "Y", 1, 1));
		list.add(new ExcelData("스토퍼,볼라드  등", "Y", 1, 1));
		list.add(new ExcelData("터치스크린  정상여부", "Y", 1, 1));
		list.add(new ExcelData("환경부카드 외 결재방식", "회원카드, QR코드, 앱", 1, 5));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("적정 조명 (기준조도:40lx)", "40 lx", 3, 1));
		list.add(new ExcelData("CCTV (관리원)", "Y", 1, 1));
		list.add(new ExcelData("비상정지버튼", "Y", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("환경부카드 사용가능", "Y", 3, 1));
		list.add(new ExcelData("차량,보행자 통행안전", "Y", 1, 1));
		list.add(new ExcelData("", "", 1, 1));
		
		list.add(new ExcelData("제품안전성", "title", 0, 0));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("시설의 적정성", "Y", 1, 1));
		list.add(new ExcelData("빗물등에 안전", "Y", 1, 1));
		list.add(new ExcelData("사람 접촉에 안전", "Y", 1, 1));
		list.add(new ExcelData("위험표지 여부", "Y", 1, 1));
		list.add(new ExcelData("분전함 LOCKING", "Y", 1, 1));
		list.add(new ExcelData("분전함 접지선", "Y", 1, 1));
		list.add(new ExcelData("계량기 점검 용이", "Y", 1, 1));
		list.add(new ExcelData("차단기 정상동작", "Y", 1, 1));
		list.add(new ExcelData("접지공사 적정성", "측정값", 1, 1));
		list.add(new ExcelData("접지저항값", "", 1, 1));
		list.add(new ExcelData("접지선의 굵기", "", 1, 1));
		list.add(new ExcelData("분전반, 충전기 외함", "", 1, 1));
		list.add(new ExcelData("충전기 케이블", "", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("배선의 적정성", "Y", 1, 1));
		list.add(new ExcelData("적합한 케이블 사용", "Y", 1, 1));
		list.add(new ExcelData("금속부분은 접지", "Y", 1, 1));
		list.add(new ExcelData("케이블의 손상 없슴", "Y", 1, 1));
		list.add(new ExcelData("", "", 3, 1));
		list.add(new ExcelData("분전함 결선상태 정상", "Y", 1, 1));
		list.add(new ExcelData("절연 저항 측정", "무한대", 1, 1));
		list.add(new ExcelData("• 1종충전기 : 1㏁ 이상 (*) \r\n • 2종충전기 : 7㏁ 이상", "무한대", 4, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("차단기 적정성", "측정값", 1, 1));
		list.add(new ExcelData("과전류차단기정격", "", 1, 1));
		list.add(new ExcelData("누전차단기정격", "", 1, 1));
		list.add(new ExcelData("감도전류/동작시간", "", 1, 1));
		list.add(new ExcelData("전선의 굵기", "", 1, 1));
		list.add(new ExcelData("", "", 2, 1));		
		list.add(new ExcelData("케이블 조임상태 정상", "", 1, 1));
		list.add(new ExcelData("", "", 5, 1));	
		
		list.add(new ExcelData("소방안전성", "title", 0, 0));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("소화설비 비치", "Y", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("비상시 신속대피 가능", "Y", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		
		list.add(new ExcelData("유지보수", "title", 0, 0));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("고장시 비상연락처", "Y", 1, 1));
		list.add(new ExcelData("주위 정리정돈", "Y", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("AS센터 연결가능", "Y", 1, 1));
		list.add(new ExcelData("불편민원신고센터 연결가능", "Y", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("고장시 표시등", "Y", 1, 1));
		
		list.add(new ExcelData("충전작동 (실차)", "title", 0, 0));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("차량 충전 작동", "Y", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("충전 속도 정상", "Y", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("비상정지버튼 작동", "Y", 1, 1));
		
		list.add(new ExcelData("충전작동 (실차, 데이터연동 확인)", "title", 0, 0));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("데이터 공유 적합성", "Y", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		list.add(new ExcelData("점검항목", "판정", 1, 1));
		
		list.add(new ExcelData("종합의견", "title", 0, 0));
		list.add(new ExcelData("점검표에 의한 발견된 문제점 및 개선 필요한 사항\r\n점거표에 없지만 점검하면서 추가적으로 개선 필요하다고 생각되는 사항", "title", 0, 0));
		list.add(new ExcelData("", "title", 6, 0));
	}
}
