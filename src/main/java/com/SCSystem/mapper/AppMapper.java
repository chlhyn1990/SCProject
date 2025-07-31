package com.SCSystem.mapper;

import com.SCSystem.dto.Manager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppMapper {

	Manager getManager(String id);
}