package com.SCSystem.service;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.ChargerFile;
import com.SCSystem.dto.ChargerStation;
import com.SCSystem.dto.Check;
import com.SCSystem.dto.CheckMst;
import com.SCSystem.dto.Distribution;
import com.SCSystem.dto.DistributionFile;
import com.SCSystem.dto.Search;
import com.SCSystem.mapper.ChargerStationMapper;
import com.SCSystem.mapper.CheckMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CheckService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CheckMapper mapper;
	@Autowired
	ChargerStationMapper chargerStationMapper;
	@Autowired
	DistributionService distributionService;
	@Value("${file.template.path}")
	private String templatePath;

	public List<CheckMst> getCheckMstByStation(int charger_station_idx) {
		return mapper.getCheckMstByStation(charger_station_idx);
	}

	public Distribution getDistributionByCheckMst(int idx) {
		return mapper.getDistributionByCheckMst(idx);
	}

	public List<CheckMst> getSearchList(Search search) {
		return mapper.getSearchList(search);
	}

	public Check get(int idx) {
		Check check = new Check();
		check.setCheckMst(mapper.getCheckMst(idx));
		check.setCompatibility(mapper.getCompatibility(check.getCheckMst()));
		check.setEnvironment(mapper.getEnvironment(check.getCheckMst()));
		check.setConvenience(mapper.getConvenience(check.getCheckMst()));
		check.setProductSafety(mapper.getProductSafety(check.getCheckMst()));
		check.setElectricalStability(mapper.getElectricalStability(check.getCheckMst()));
		check.setFireSafety(mapper.getFireSafety(check.getCheckMst()));
		check.setMaintenance(mapper.getMaintenance(check.getCheckMst()));
		check.setChargingOperation(mapper.getChargingOperation(check.getCheckMst()));
		check.setOpinion(mapper.getOpinion(check.getCheckMst()));
		check.setDistributionFile(mapper.getDistributionFile(check.getCheckMst()));
		return check;
	}

	public List<Check> getCheckList(int charger_station_idx) {
		List<Check> report = new ArrayList<Check>();
		List<CheckMst> checkMstList = mapper.getCheckMstByStation(charger_station_idx);

		for (CheckMst checkMst : checkMstList) {
			Check check = new Check();
			check.setCheckMst(checkMst);
			check.setCompatibility(mapper.getCompatibility(check.getCheckMst()));
			check.setEnvironment(mapper.getEnvironment(check.getCheckMst()));
			check.setConvenience(mapper.getConvenience(check.getCheckMst()));
			check.setProductSafety(mapper.getProductSafety(check.getCheckMst()));
			check.setElectricalStability(mapper.getElectricalStability(check.getCheckMst()));
			check.setFireSafety(mapper.getFireSafety(check.getCheckMst()));
			check.setMaintenance(mapper.getMaintenance(check.getCheckMst()));
			check.setChargingOperation(mapper.getChargingOperation(check.getCheckMst()));
			check.setOpinion(mapper.getOpinion(check.getCheckMst()));
			check.setDistributionFile(mapper.getDistributionFile(check.getCheckMst()));
			report.add(check);
		}

		return report;
	}

	public int insert(Integer company_idx, Integer manager_idx, Integer charger_station_idx, Integer distribution_idx) {
		try {
			return mapper.insertCheck(company_idx, manager_idx, charger_station_idx, distribution_idx);
		} catch (Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}

	@Transactional
	public int update(Check check) {
		try {
			int result = 0;
			result += mapper.updateCheckMst(check.getCheckMst());
			result += mapper.updateCompatibility(check.getCompatibility());
			result += mapper.updateEnvironment(check.getEnvironment());
			result += mapper.updateConvenience(check.getConvenience());
			result += mapper.updateProductSafety(check.getProductSafety());
			result += mapper.updateElectricalStability(check.getElectricalStability());
			result += mapper.updateFireSafety(check.getFireSafety());
			result += mapper.updateMaintenance(check.getMaintenance());
			result += mapper.updateChargingOperation(check.getChargingOperation());
			result += mapper.updateOpinion(check.getOpinion());
			result += mapper.updateDistributionFile(check.getDistributionFile());
			return result;
		} catch (Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}

	public int delete(int check_mst_idx) {
		try {
			return mapper.deleteCheck(check_mst_idx);
		} catch (Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}

	public int getCheckMstIdxByDistribution(int distribution_idx) {
		return mapper.getCheckMstIdxByDistribution(distribution_idx);
	}

	ChargerFile getChargerFile(int idx) {
		return mapper.getChargerFile(idx);
	}

	int insertChargerFile(ChargerFile chargerFile) {
		return mapper.insertChargerFile(chargerFile);
	}

	int updateChargerFile(ChargerFile chargerFile) {
		return mapper.updateChargerFile(chargerFile);
	}

	int deleteChargerFile(int charger_idx) {
		return mapper.deleteChargerFile(charger_idx);
	}

	int insertDistributionFile(DistributionFile distributionFile) {
		return mapper.insertDistributionFile(distributionFile);
	}

	int updateDistributionFile(DistributionFile distributionFile) {
		return mapper.updateDistributionFile(distributionFile);
	}

	public int deleteDistributionFile(int distribution_idx) {
		return mapper.deleteDistributionFile(distribution_idx);
	}

	public byte[] createInspectionForm(int charger_station_idx) throws IOException {
		InputStream templateStream = null;
		File templateFile = null;
		XSSFWorkbook workbook = null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		ChargerStation chargerStation = chargerStationMapper.get(charger_station_idx);
		chargerStation.setDistributionList(distributionService.getListByStation(charger_station_idx));
		List<Check> checkList = getCheckList(charger_station_idx);

		try {
			templateFile = new File(templatePath + "ex.xlsx");
			if (templateFile.exists() && templateFile.isFile()) {
				templateStream = new FileInputStream(templateFile);
			}

			workbook = new XSSFWorkbook(templateStream);
			XSSFSheet templateSheet = workbook.getSheetAt(0);
			XSSFSheet templateSheet2 = workbook.getSheetAt(1);
			XSSFSheet templateSheet3 = workbook.getSheetAt(2);
			XSSFSheet sheetFrm;
			XSSFSheet sheet2Frm;
			XSSFSheet sheet3Frm;

			for (int i = 0; i < chargerStation.getDistributionList().size(); i++) {
				Distribution distribution = chargerStation.getDistributionList().get(i);

				if (i == 0) {
					sheetFrm = templateSheet;
					workbook.setSheetName(i, distribution.getPlace3());
					sheet2Frm = templateSheet2;
					workbook.setSheetName(i + 1, "구역별 사진" + (i + 1));
					sheet3Frm = templateSheet3;
					workbook.setSheetName(i + 2, "기기별 사진" + (i + 1));
				} else {
					sheetFrm = workbook.cloneSheet(0);
					workbook.setSheetName(i + 2, distribution.getPlace3());
					sheet2Frm = workbook.cloneSheet(1);
					workbook.setSheetName(i + 3, "구역별 사진" + (i + 1));
					sheet3Frm = workbook.cloneSheet(2);
					workbook.setSheetName(i + 4, "기기별 사진" + (i + 1));
				}
			}

			for (int i = 0; i < chargerStation.getDistributionList().size(); i++) {

				Check check = checkList.get(i);

				// 분전함(1시트)
				String check_dt = check.getCheckMst().getCheck_dt() != null ? check.getCheckMst().getCheck_dt() : "";
				Distribution distribution = chargerStation.getDistributionList().get(i);
				XSSFSheet sheet =  workbook.getSheet(distribution.getPlace3());
				XSSFSheet sheet2 =  workbook.getSheet("구역별 사진" + (i + 1));

				Row row = sheet.getRow(6);
				row.getCell(1)
						.setCellValue(check_dt.equals("") ? ""
								: check_dt.substring(0, 4) + "년 " + check_dt.substring(5, 7) + "월 "
										+ check_dt.substring(8, 10) + "일");
				row.getCell(4).setCellValue(check.getCheckMst().getTemperature());
				row.getCell(8).setCellValue(check.getCheckMst().getManager_name());

				row = sheet.getRow(8);
				row.getCell(1).setCellValue(chargerStation.getName());
				row.getCell(6).setCellValue(distribution.getPlace1());
				row.getCell(8).setCellValue(distribution.getPlace2());

				row = sheet.getRow(9);
				row.getCell(6).setCellValue(distribution.getPlace3());

				row = sheet.getRow(10);
				row.getCell(1).setCellValue(chargerStation.getChargerCompany());
				row.getCell(6).setCellValue(chargerStation.getCompany_name());

				row = sheet.getRow(11);
				row.getCell(1).setCellValue(chargerStation.getLongitude());
				row.getCell(3).setCellValue(chargerStation.getLatitude());
				row.getCell(6).setCellValue(distribution.getChargerList().size());

				row = sheet.getRow(12);
				row.getCell(6).setCellValue(distribution.getChargerList().size());
				row.getCell(9).setCellValue(0);

				row = sheet.getRow(13);
				row.getCell(6).setCellValue(0);
				row.getCell(9).setCellValue(0);

				row = sheet.getRow(14);
				row.getCell(1).setCellValue(chargerStation.getAddr() + " " + chargerStation.getDetail_addr());
				row.getCell(8).setCellValue(distribution.getVolt());

				row = sheet.getRow(15);
				row.getCell(8).setCellValue(distribution.getWatt());

				row = sheet.getRow(16);
				row.getCell(2).setCellValue(distribution.getStand_type().equals("Y") ? "■" : "□");
				row.getCell(4).setCellValue(distribution.getWall_type().equals("Y") ? "■" : "□");
				row.getCell(6).setCellValue(distribution.getMove_type().equals("Y") ? "■" : "□");
				row.getCell(8).setCellValue("기타 ( " + distribution.getEtc_type() + " ) 충전기");

				row = sheet.getRow(17);
				String screen = distribution.getScreen().equals("Y") ? "■화면," : "□화면,";
				String touch = distribution.getTouch().equals("Y") ? "■터치," : "□터치,";
				String communicate = distribution.getCommunicate().equals("Y") ? "■통신," : "□통신,";
				String card = distribution.getCard().equals("Y") ? "■카드," : "□카드,";
				String charge = distribution.getCharge().equals("Y") ? "■충전," : "□충전,";
				String gate = distribution.getGate().equals("Y") ? "■차단기," : "□차단기,";
				String power = distribution.getPower().equals("Y") ? "■전원," : "□전원,";
				String err = distribution.getErr().equals("Y") ? "■간헐오류," : "□간헐오류,";
				String connector = distribution.getConnector().equals("Y") ? "■커넥터," : "□커넥터,";
				String etc = distribution.getEtc().equals("Y") ? "■기타" : "□기타";
				String result = screen + touch + communicate + card + charge + gate + power + err + connector + etc;
				row.getCell(2).setCellValue(result);

				// 적합성
				row = sheet.getRow(22);
				row.getCell(2).setCellValue(check.getCompatibility().getOpen());
				row.getCell(5).setCellValue(check.getCompatibility().getMilestone());
				row.getCell(9).setCellValue(check.getCompatibility().getSpace());

				row = sheet.getRow(23);
				row.getCell(2).setCellValue(check.getCompatibility().getAccess());
				row.getCell(5).setCellValue(check.getCompatibility().getRapid());
				row.getCell(9).setCellValue(check.getCompatibility().getFree());

				// 환경성
				row = sheet.getRow(28);
				row.getCell(2).setCellValue(check.getEnvironment().getTemperature());
				row.getCell(5).setCellValue(check.getEnvironment().getSlip());
				row.getCell(9).setCellValue(check.getEnvironment().getFlooding());

				row = sheet.getRow(29);
				row.getCell(2).setCellValue(check.getEnvironment().getGas());
				row.getCell(5).setCellValue(check.getEnvironment().getVentilation());
				row.getCell(9).setCellValue(check.getEnvironment().getVibration());

				row = sheet.getRow(30);
				row.getCell(2).setCellValue(check.getEnvironment().getOpenness());
				row.getCell(5).setCellValue(check.getEnvironment().getSnowrain());

				// 편리성
				row = sheet.getRow(35);
				row.getCell(2).setCellValue(check.getConvenience().getHomepage());
				row.getCell(5).setCellValue(check.getConvenience().getLighting());
				row.getCell(9).setCellValue(check.getConvenience().getCard());

				row = sheet.getRow(36);
				row.getCell(2).setCellValue(check.getConvenience().getFacility());
				row = sheet.getRow(37);
				row.getCell(2).setCellValue(check.getConvenience().getStatus());

				row = sheet.getRow(38);
				row.getCell(2).setCellValue(check.getConvenience().getStopper());
				row.getCell(5).setCellValue(check.getConvenience().getCctv());
				row.getCell(9).setCellValue(check.getConvenience().getTraffic());

				row = sheet.getRow(39);
				row.getCell(2).setCellValue(check.getConvenience().getScreen());
				row.getCell(5).setCellValue(check.getConvenience().getEmergency());

				row = sheet.getRow(40);
				row.getCell(2).setCellValue(check.getConvenience().getPayment());

				// 제품안정성
				row = sheet.getRow(45);
				row.getCell(2).setCellValue(check.getProductSafety().getRust());
				row.getCell(5).setCellValue(check.getProductSafety().getConnector());
				row.getCell(9).setCellValue(check.getProductSafety().getDiscolor());

				row = sheet.getRow(46);
				row.getCell(2).setCellValue(check.getProductSafety().getStopper());
				row.getCell(5).setCellValue(check.getProductSafety().getLock());
				row.getCell(9).setCellValue(check.getProductSafety().getPad());

				// 전기안정성
				row = sheet.getRow(50);
				row.getCell(2).setCellValue(check.getElectricalStability().getFacilities());
				row.getCell(5).setCellValue(check.getElectricalStability().getWiring());
				row.getCell(9).setCellValue(check.getElectricalStability().getGate_value());

				row = sheet.getRow(51);
				row.getCell(2).setCellValue(check.getElectricalStability().getRainwater());
				row.getCell(5).setCellValue(check.getElectricalStability().getSuitable_cable());
				row.getCell(9).setCellValue(check.getElectricalStability().getOvercurrentW());
				row.getCell(10).setCellValue(check.getElectricalStability().getOvercurrentA());

				row = sheet.getRow(52);
				row.getCell(2).setCellValue(check.getElectricalStability().getContact());
				row.getCell(5).setCellValue(check.getElectricalStability().getMetal_part());
				row.getCell(9).setCellValue(check.getElectricalStability().getLeakageW());
				row.getCell(10).setCellValue(check.getElectricalStability().getLeakageA());

				row = sheet.getRow(53);
				row.getCell(2).setCellValue(check.getElectricalStability().getDanger());
				row.getCell(5).setCellValue(check.getElectricalStability().getCable_damage());
				row.getCell(9).setCellValue(check.getElectricalStability().getSensitivity());

				row = sheet.getRow(54);
				row.getCell(2).setCellValue(check.getElectricalStability().getLocking());
				row.getCell(9).setCellValue(check.getElectricalStability().getWire_thickness());
				row = sheet.getRow(55);
				row.getCell(2).setCellValue(check.getElectricalStability().getWire());
				row = sheet.getRow(56);
				row.getCell(2).setCellValue(check.getElectricalStability().getMeter());

				row = sheet.getRow(57);
				row.getCell(2).setCellValue(check.getElectricalStability().getGate());
				row.getCell(5).setCellValue(check.getElectricalStability().getWiring_status());
				row.getCell(9).setCellValue(check.getElectricalStability().getCable_tightening());

				row = sheet.getRow(58);
				row.getCell(2).setCellValue(check.getElectricalStability().getGrounding_work());
				row.getCell(5).setCellValue(check.getElectricalStability().getInsulation_resistance());

				row = sheet.getRow(59);
				row.getCell(2).setCellValue(check.getElectricalStability().getResistance());
				String type1 = check.getElectricalStability().getType_charger1().equals("Y") ? "• 1종충전기 : 1㏁ 이상 (*)\n"
						: "• 1종충전기 : 1㏁ 이상\n";
				String type2 = check.getElectricalStability().getType_charger2().equals("Y") ? "• 2종충전기 : 7㏁ 이상 (*)"
						: "• 2종충전기 : 7㏁ 이상";
				row.getCell(3).setCellValue(type1 + type2);
				row = sheet.getRow(60);
				row.getCell(2).setCellValue(check.getElectricalStability().getThickness());
				row = sheet.getRow(61);
				row.getCell(2).setCellValue(check.getElectricalStability().getDistribution());
				row = sheet.getRow(62);
				row.getCell(2).setCellValue(check.getElectricalStability().getCable());

				// 소방안정성
				row = sheet.getRow(66);
				row.getCell(2).setCellValue(check.getFireSafety().getFacility());
				row.getCell(5).setCellValue(check.getFireSafety().getEvacuation());

				// 유지보수
				row = sheet.getRow(70);
				row.getCell(2).setCellValue(check.getMaintenance().getContact());
				row.getCell(5).setCellValue(check.getMaintenance().getAscenter());
				row.getCell(9).setCellValue(check.getMaintenance().getLight());

				row = sheet.getRow(71);
				row.getCell(2).setCellValue(check.getMaintenance().getOrganize());
				row.getCell(5).setCellValue(check.getMaintenance().getComplaint());

				// 충전작동
				row = sheet.getRow(75);
				row.getCell(2).setCellValue(check.getChargingOperation().getCharge());
				row.getCell(5).setCellValue(check.getChargingOperation().getSpeed());
				row.getCell(9).setCellValue(check.getChargingOperation().getButton());

				row = sheet.getRow(79);
				row.getCell(2).setCellValue(check.getChargingOperation().getShare());

				// 종합의견
				row = sheet.getRow(82);
				row.getCell(0).setCellValue(check.getOpinion().getContent());

				// 분전함 사진(2시트)
				insertImageToExcel(sheet2, check.getDistributionFile().getForeground_path(), 1, 0, 5, 1);

				insertImageToExcel(sheet2, check.getDistributionFile().getExternal_path(), 3, 0, 5, 1);
				insertImageToExcel(sheet2, check.getDistributionFile().getInternal_path(), 3, 6, 5, 1);

				insertImageToExcel(sheet2, check.getDistributionFile().getMccb_path(), 5, 0, 5, 1);
				insertImageToExcel(sheet2, check.getDistributionFile().getResistance_path(), 5, 6, 5, 1);
				row = sheet2.getRow(6);
				row.getCell(3).setCellValue(check.getElectricalStability().getOvercurrentA());
				row.getCell(9).setCellValue(check.getElectricalStability().getResistance());

				insertImageToExcel(sheet2, check.getDistributionFile().getWire_status_path(), 9, 0, 5, 1);
				insertImageToExcel(sheet2, check.getDistributionFile().getMeter_path(), 9, 6, 5, 1);
				row = sheet2.getRow(10);
				row.getCell(7).setCellValue(check.getDistributionFile().getMeter_text());

				insertImageToExcel(sheet2, check.getDistributionFile().getModem_front_path(), 11, 0, 5, 1);
				insertImageToExcel(sheet2, check.getDistributionFile().getModem_back_path(), 11, 6, 5, 1);
				row = sheet2.getRow(12);
				row.getCell(3).setCellValue(check.getDistributionFile().getModem_front_text());
				row.getCell(9).setCellValue(check.getDistributionFile().getModem_back_text());

				insertImageToExcel(sheet2, check.getDistributionFile().getBollard_path(), 13, 0, 5, 1);
				insertImageToExcel(sheet2, check.getDistributionFile().getEtc_path(), 13, 6, 5, 1);

			}
			workbook.write(outputStream);
			workbook.close();
			return outputStream.toByteArray();

		} finally {
			if (templateStream != null) {
				try {
					templateStream.close();
				} catch (IOException e) {
					// 닫기 실패는 무시
				}
			}
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					// 닫기 실패는 무시
				}
			}
		}
	}

	private void insertImageToExcel(Sheet sheet, String imageUrl, int rowNum, int colNum, int mergeWidth,
			int mergeHeight) throws IOException {
		if (imageUrl == null || imageUrl.isEmpty()) {
			return;
		}

		try {
			byte[] imageBytes = getImageBytes(imageUrl);

			// 이미지 타입 확인
			int pictureType = getPictureType(imageUrl);

			// 워크북에 이미지 추가
			int pictureIdx = sheet.getWorkbook().addPicture(imageBytes, pictureType);

			// Drawing 객체 생성
			Drawing<?> drawing = sheet.createDrawingPatriarch();

			// ClientAnchor 설정 - 병합된 셀 크기에 맞춤
			CreationHelper helper = sheet.getWorkbook().getCreationHelper();
			ClientAnchor anchor = helper.createClientAnchor();

			// 시작 위치 설정
			anchor.setCol1(colNum);
			anchor.setRow1(rowNum);
			// 끝 위치 설정 (병합된 셀 크기만큼)
			anchor.setCol2(colNum + mergeWidth);
			anchor.setRow2(rowNum + mergeHeight);

			// 이미지가 셀에 꽉 차도록 설정 (선택사항)
			anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);

			// 이미지 삽입
			drawing.createPicture(anchor, pictureIdx);

		} catch (Exception e) {
			System.err.println("이미지 삽입 실패: " + imageUrl + " - " + e.getMessage());

			// 실패 시 텍스트 표시
			Row row = sheet.getRow(rowNum);
			if (row == null)
				row = sheet.createRow(rowNum);
			Cell cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue("이미지: " + new File(imageUrl).getName());
		}
	}

	// 이미지 타입 확인
	private int getPictureType(String imageUrl) {
		String lowerUrl = imageUrl.toLowerCase();
		if (lowerUrl.endsWith(".jpg") || lowerUrl.endsWith(".jpeg")) {
			return Workbook.PICTURE_TYPE_JPEG;
		} else if (lowerUrl.endsWith(".png")) {
			return Workbook.PICTURE_TYPE_PNG;
		} else {
			return Workbook.PICTURE_TYPE_PNG; // 기본값
		}
	}

	private byte[] getImageBytes(String imageUrl) throws IOException {
		// 로컬 파일 경로인 경우
		if (imageUrl.startsWith("C:\\") || imageUrl.startsWith("/home/")) {
			File file = new File(imageUrl);
			return Files.readAllBytes(file.toPath());
		}
		// 웹 URL인 경우
		else if (imageUrl.startsWith("http")) {
			URL url = new URL(imageUrl);
			try (InputStream inputStream = url.openStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

				byte[] buffer = new byte[4096];
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				return outputStream.toByteArray();
			}
		}
		// 그 외의 경우
		else {
			throw new IOException("지원하지 않는 이미지 경로: " + imageUrl);
		}
	}
}
