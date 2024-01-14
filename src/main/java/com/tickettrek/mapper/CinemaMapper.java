package com.tickettrek.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tickettrek.dtos.CinemaDTO;
import com.tickettrek.module.Cinema;

@Component
public class CinemaMapper {
	public CinemaDTO toDTO(Cinema cinema) {
		CinemaDTO dto = new CinemaDTO();
		dto.setAddress(cinema.getAddress());
		dto.setImage(cinema.getImage());
		dto.setName(cinema.getName());
		dto.setPhone(cinema.getPhone());
		return dto;
	}

	public List<CinemaDTO> toDTOList(List<Cinema> module) {
		return module.stream().map(e -> toDTO(e)).collect(Collectors.toList());

	}
	public Cinema toModule(CinemaDTO dto) {
		Cinema module = new Cinema();
		module.setAddress(dto.getAddress());
		module.setImage(dto.getImage());
		module.setName(dto.getName());
		module.setPhone(dto.getPhone());
		return module;
	}
}
