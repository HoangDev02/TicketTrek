package com.tickettrek.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tickettrek.dtos.SeatsDTO;
import com.tickettrek.module.Seats;
import com.tickettrek.services.AuditoriumService;
import com.tickettrek.services.TiketService;

@Component
public class SeatsMapper {
	
	@Autowired
	private AuditoriumService auditoriumService;
	
	@Autowired
	private TiketService tiketService;
	
	public SeatsDTO toDTO(Seats module) {
		SeatsDTO dto = new SeatsDTO();
		dto.setId(module.getId());
		dto.setSeatNumber(module.getSeatNumber());
		dto.setSeatType(module.isSeatType());
//		dto.setTiketId(module.getTikets().getId());
		dto.setAuditoriumId(module.getAuditorium().getId());
		return dto;
	}
	public List<SeatsDTO> toDTOList(List<Seats> module) {
		return module.stream().map((cat) -> toDTO(cat)).collect(Collectors.toList());
	}
	public Seats toModule(SeatsDTO dto) {
		Seats module = new Seats();
		module.setSeatNumber(dto.getSeatNumber());
		module.setSeatType(dto.isSeatType());
		module.setAuditorium(auditoriumService.getAuditoriumById(dto.getAuditoriumId()));
//		module.setTikets(tiketService.getTiketById(dto.getTiketId()));
		return module;
	}
}
