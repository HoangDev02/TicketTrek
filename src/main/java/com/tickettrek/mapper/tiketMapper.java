package com.tickettrek.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tickettrek.dtos.tiketDTO;
import com.tickettrek.module.Tiket;

@Component
public class tiketMapper {
	public tiketDTO toDTO(Tiket module) {
		tiketDTO dto = new tiketDTO();
		dto.setId(module.getId());
		dto.setPrice(module.getPrice());
//		dto.setSeats(module.getSeats().getId());
//		dto.setPeopleDetail(module.getPeopleDetail());
//		dto.setBookingDetail(module.getBookingDetail());
		return dto;
	}
	public List<tiketDTO> toDTOList(List<Tiket> module) {
		return module.stream().map((cat) -> toDTO(cat)).collect(Collectors.toList());
	}
	public Tiket toModule(tiketDTO dto) {
		Tiket module = new Tiket();
		module.setId(module.getId());
		module.setPrice(module.getPrice());
//		module.setSeats(module.getSeats());
//		module.setPeopleDetail(module.getPeopleDetail());
//		module.setBookingDetail(dto.getBookingDetail());
		return module;
	}
}
