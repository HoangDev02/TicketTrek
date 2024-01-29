package com.tickettrek.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tickettrek.dtos.PeopleDTO;
import com.tickettrek.module.People;

@Component
public class PeopleMapper {
	public PeopleDTO toDTO(People module) {
		PeopleDTO dto = new PeopleDTO();
		dto.setId(module.getId());
		dto.setName(module.getName());
		return dto;
	}

	public List<PeopleDTO> toDTOList(List<People> models) {
		return models.stream().map(cat -> toDTO(cat)).collect(Collectors.toList());
	}
	
	public People toModule(PeopleDTO dto) {
		People module = new People();
		module.setId(dto.getId());
		module.setName(dto.getName());
		return module;
	}
}
