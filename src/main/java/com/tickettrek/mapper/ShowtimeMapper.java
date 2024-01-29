package com.tickettrek.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tickettrek.dtos.ShowTimeDTO;
import com.tickettrek.module.ShowTime;
import com.tickettrek.services.AuditoriumService;
import com.tickettrek.services.MovieService;

@Component
public class ShowtimeMapper {
	@Autowired
	private AuditoriumService auditoriumService;
	@Autowired
	private MovieService movieService;
	
	public ShowTimeDTO toDTO(ShowTime module) {
//		Integer auditorium = auditoriumShowTimeService.getAuditoriumIdByShowTimeId(module.getId());
		ShowTimeDTO dto = new ShowTimeDTO();
		dto.setId(module.getId());
		dto.setShowDateTime(module.getShowDateTime());
		dto.setAuditoriumId(module.getAuditorium().getId());
		dto.setMovie(module.getMovie().getId());
		return dto;
	}
	public List<ShowTimeDTO> toDTOList(List<ShowTime> module) {
		return module.stream().map(e -> toDTO(e)).collect(Collectors.toList());
	}
	public ShowTime toModule(ShowTimeDTO dto) {
		ShowTime module = new ShowTime();
		module.setId(dto.getId());
		module.setShowDateTime(dto.getShowDateTime());
		module.setAuditorium(auditoriumService.getAuditoriumById(dto.getAuditoriumId()));
		module.setMovie(movieService.findById(dto.getMovie()));
		return module;
	}
}
