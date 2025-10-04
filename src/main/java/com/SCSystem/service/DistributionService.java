package com.SCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SCSystem.dto.Charger;
import com.SCSystem.dto.ChargerFile;
import com.SCSystem.dto.Distribution;
import com.SCSystem.dto.DistributionFile;
import com.SCSystem.mapper.DistributionMapper;
import com.SCSystem.mapper.ChargerMapper;
import com.SCSystem.mapper.CheckMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DistributionService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	DistributionMapper mapper;
	@Autowired
	ChargerService chargerService;
	@Autowired
	CheckService checkService;
	
	public List<Distribution> getList() {
		List<Distribution> distributionList = mapper.getList();
		return distributionList;
	}

	public List<Distribution> getListByStation(int charger_station_idx) {
		List<Distribution> distributionList = mapper.getListByStation(charger_station_idx);
		for(int i = 0; i < distributionList.size(); i++) {
			distributionList.get(i).setChargerList(chargerService.getListByDistribution(distributionList.get(i).getIdx()));
		}
		return distributionList;
	}
	
	public Distribution get(int idx) {
		return mapper.get(idx);
	}
	
	public int insert(Distribution dto) {
		try {
			int distributionIdx = mapper.insert(dto);
			int checkMstIdx = checkService.getCheckMstIdxByDistribution(distributionIdx);
			DistributionFile distributionFile = new DistributionFile();
			distributionFile.setDistribution_idx(distributionIdx);
			distributionFile.setCheck_mst_idx(checkMstIdx);
			checkService.insertDistributionFile(distributionFile);
			return mapper.insert(dto);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int update(Distribution dto) {
		try {
			return mapper.update(dto);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
	
	public int delete(int idx) {
		try {
			List<Charger> list = chargerService.getListByDistribution(idx);
			for(Charger charger : list) {
				chargerService.delete(charger.getIdx());
			}
			return mapper.delete(idx);
		}catch(Exception e) {
			log.warn(e.getMessage());
			return 0;
		}
	}
}

