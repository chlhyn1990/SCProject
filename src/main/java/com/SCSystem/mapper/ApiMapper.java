package com.SCSystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.SCSystem.dto.Manager;

@Mapper
public interface ApiMapper {

	Manager getManager(Manager manager);
	
	int insertManager(Manager manager);

}

