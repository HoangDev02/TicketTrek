package com.tickettrek.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tickettrek.dtos.tiketDTO;
import com.tickettrek.module.PeopleDetail;
import com.tickettrek.module.Tiket;
import com.tickettrek.services.PeopleService;
import com.tickettrek.services.SeatsService;

@Component
public class tiketMapper {
	@Autowired
	private PeopleService peopleService;
	@Autowired SeatsService seatsService;
	public tiketDTO toDTO(Tiket module) {
		tiketDTO dto = new tiketDTO();
//		dto.setId(module.getId());
		dto.setPrice(module.getPrice());
		dto.setStatus(module.isStatus());
		dto.setSeats(module.getSeats().getId());
		dto.setPeopleId(module.getPeopleDetail().get(0).getId().getPeopleId());
		return dto;
	}

	public List<tiketDTO> toDTOList(List<Tiket> module) {
		return module.stream().map((cat) -> toDTO(cat)).collect(Collectors.toList());
	}

	public Tiket toModule(tiketDTO dto) {
		Tiket module = new Tiket();
//		module.setId(dto.getId());
		module.setPrice(dto.getPrice());
		module.setStatus(dto.isStatus());
		module.setSeats(seatsService.getSeatsById(dto.getSeats()));
		PeopleDetail peopleDetail = new PeopleDetail();
		peopleDetail.setPeople(peopleService.getPeopleById(dto.getPeopleId()));
		module.setPeopleDetail(List.of(peopleDetail));
		return module;
	}
}
