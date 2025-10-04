package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.Charger;
import com.SCSystem.dto.ChargerFile;
import com.SCSystem.mapper.ChargerMapper;
import com.SCSystem.mapper.CheckMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChargerService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ChargerMapper mapper;
	@Autowired
	CheckService checkService;
	
	public List<Charger> getListByDistribution(int distribution_idx) {
		return mapper.getListByDistribution(distribution_idx);
	}

	public List<Charger> getSearchList(String search) {
		return mapper.getSearchList(search);
	}
	
	public Charger get(int idx) {
		return mapper.get(idx);
	}
	@Transactional
	public int insert(Charger dto) {
		try {
			mapper.insert(dto);
			int chargerIdx = dto.getIdx();
			int checkMstIdx = checkService.getCheckMstIdxByDistribution(dto.getDistribution_idx());
			ChargerFile chargerFile = new ChargerFile();
			chargerFile.setCharger_idx(chargerIdx);
			chargerFile.setCheck_mst_idx(checkMstIdx);
			checkService.insertChargerFile(chargerFile);
			return chargerIdx;
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}

	public int update(Charger dto) {
		try {
			return mapper.update(dto);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	@Transactional
	public int delete(int idx) {
		try {
			checkService.deleteChargerFile(idx);
			return mapper.delete(idx);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
}

