CREATE DEFINER=`as_evse`@`localhost` PROCEDURE `as_evse`.`insert_station_default_data`(
    IN p_company_idx INT,
    IN p_manager_idx INT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;
    
    START TRANSACTION;

    INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검일자', 1, 1, 1, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '주변 온도/습도', 1, 1, 2, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검자', 1, 1, 3, 'N', NOW(), NOW());
    
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '적합성', 0, 0, 4, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 5, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '개방 여부', 1, 1, 6, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '쉽게 접근가능', 1, 1, 7, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 8, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '이정표 설치 여부', 1, 1, 9, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '(완속,급속) 표시', 1, 1, 10, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 11, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '적정공간 확보', 1, 1, 12, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '무료주차', 1, 1, 13, 'N', NOW(), NOW());
	
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '환경성', 0, 0, 14, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 15, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '주위온도  적정성(옥내:-5℃ ~ +40℃,옥외:-25℃ ~ +40℃)', 1, 1, 16, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '분진,가스등에  안전', 1, 1, 17, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '발열대비', 1, 1, 18, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '미끄럼방지  여부', 1, 1, 19, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '환기 적정성', 1, 1, 20, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '눈,비에 안전', 1, 1, 21, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 22, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '침수방지 등', 1, 1, 23, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '진동,발열체에 안전', 1, 1, 24, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '', 1, 1, 25, 'N', NOW(), NOW());
	
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '편리성', 0, 0, 26, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 27, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '홈페이지 (누리집) 연동여부', 1, 1, 28, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '충전시설 위치', 1, 1, 29, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '상태정보 확인', 1, 1, 30, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '스토퍼,볼라드  등', 1, 1, 31, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '터치스크린  정상여부', 1, 1, 32, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '환경부카드 외 결재방식', 1, 1, 33, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 34, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '적정 조명 (기준조도:40lx)', 3, 1, 35, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, 'CCTV (관리원)', 1, 1, 36, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '비상정지버튼', 1, 1, 37, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 38, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '환경부카드 사용가능', 3, 1, 39, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '차량,보행자 통행안전', 1, 1, 40, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '', 1, 1, 41, 'N', NOW(), NOW());
	
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '제품안전성', 0, 0, 42, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 43, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '시설의 적정성', 1, 1, 44, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '빗물등에 안전', 1, 1, 45, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '사람 접촉에 안전', 1, 1, 46, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '위험표지 여부', 1, 1, 47, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '분전함 LOCKING', 1, 1, 48, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '분전함 접지선', 1, 1, 49, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '계량기 점검 용이', 1, 1, 50, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '차단기 정상동작', 1, 1, 51, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '접지공사 적정성', 1, 1, 52, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '접지저항값', 1, 1, 53, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '접지선의 굵기', 1, 1, 54, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '분전반, 충전기 외함', 1, 1, 55, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '충전기 케이블', 1, 1, 56, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 57, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '배선의 적정성', 1, 1, 58, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '적합한 케이블 사용', 1, 1, 59, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '금속부분은 접지', 1, 1, 60, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '케이블의 손상 없음', 1, 1, 61, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '', 3, 1, 62, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '분전함 결선상태 정상', 1, 1, 63, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '절연 저항 측정', 1, 1, 64, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '• 1종충전기 : 1㏁ 이상 (*) \r\n • 2종충전기 : 7㏁ 이상', 4, 1, 65, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 66, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '차단기 적정성', 1, 1, 67, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '과전류차단기정격', 1, 1, 68, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '누전차단기정격', 1, 1, 69, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '감도전류/동작시간', 1, 1, 70, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '전선의 굵기', 1, 1, 71, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '', 2, 1, 72, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '케이블 조임상태 정상', 1, 1, 73, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '', 5, 1, 74, 'N', NOW(), NOW());
	
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '소방안전성', 0, 0, 75, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 76, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '소화설비 비치', 1, 1, 77, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 78, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '비상시 신속대피 가능', 1, 1, 79, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 80, 'N', NOW(), NOW());
	
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '유지보수', 0, 0, 81, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 82, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '고장시 비상연락처', 1, 1, 83, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '주위 정리정돈', 1, 1, 84, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 85, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, 'AS센터 연결가능', 1, 1, 86, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '불편민원신고센터 연결가능', 1, 1, 87, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 88, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '고장시 표시등', 1, 1, 89, 'N', NOW(), NOW());
	
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '충전작동 (실차)', 0, 0, 90, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 91, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '차량 충전 작동', 1, 1, 92, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 93, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '충전 속도 정상', 1, 1, 94, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 95, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '비상정지버튼 작동', 1, 1, 96, 'N', NOW(), NOW());
	
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '충전작동 (실차, 데이터연동 확인)', 0, 0, 97, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 98, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '데이터 공유 적합성', 1, 1, 99, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 100, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검항목', 1, 1, 101, 'N', NOW(), NOW());
	
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '종합의견', 0, 0, 102, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '점검표에 의한 발견된 문제점 및 개선 필요한 사항\r\n점거표에 없지만 점검하면서 추가적으로 개선 필요하다고 생각되는 사항', 0, 0, 103, 'N', NOW(), NOW());
	INSERT INTO as_evse.check_list(company_idx, manager_idx, checking_name, row, col, ord, photo_yn, create_dt, modify_dt) VALUES (p_company_idx, p_manager_idx, '', 6, 1, 104, 'N', NOW(), NOW());

    COMMIT;
END