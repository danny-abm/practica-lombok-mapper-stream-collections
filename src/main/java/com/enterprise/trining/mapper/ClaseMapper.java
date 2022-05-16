package com.enterprise.trining.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.enterprise.training.model.ClaseDTO;
import com.enterprise.training.model.main.ClaseMain;

import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface ClaseMapper {
	
	ClaseMapper INSTANCE = Mappers.getMapper(ClaseMapper.class);
	
	@Mapping(source="name", target="nombre")
	@Mapping(source="codigo", target="code")
	ClaseDTO ClaseMainToCLaseDTO (ClaseMain main);
	

}
