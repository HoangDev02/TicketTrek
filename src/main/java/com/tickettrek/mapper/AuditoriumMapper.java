package com.tickettrek.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tickettrek.dtos.AuditoriumDTO;
import com.tickettrek.module.Auditorium;
import com.tickettrek.services.CinemaService;

@Component
public class AuditoriumMapper {
	@Autowired
	private CinemaService cinemaService;
	public AuditoriumDTO toDTO(Auditorium module) {
		AuditoriumDTO dto = new AuditoriumDTO();
		dto.setId(module.getId());
		dto.setName(module.getName());
		dto.setNumberOfColumns(module.getNumberOfColumns());
		dto.setNumberOfRows(module.getNumberOfRows());
		dto.setCinemaId(module.getCinema().getId());
		return dto;
	}
	public List<AuditoriumDTO> toDTOList(List<Auditorium> module) {
		return module.stream().map((cat) -> toDTO(cat)).collect(Collectors.toList());
	}
	public Auditorium toModule(AuditoriumDTO dto) {
		Auditorium module = new Auditorium();
		module.setId(dto.getId());	
		module.setName(dto.getName());
		module.setNumberOfColumns(dto.getNumberOfColumns());
		module.setNumberOfRows(dto.getNumberOfRows());
		module.setCinema(cinemaService.getCinemaById(dto.getCinemaId()));
		return module;
	}
}	
