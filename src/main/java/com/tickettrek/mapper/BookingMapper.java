package com.tickettrek.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tickettrek.dtos.BookingDTO;
import com.tickettrek.module.Booking;
import com.tickettrek.services.TiketService;
import com.tickettrek.services.UserService;

@Component
public class BookingMapper {
	
	@Autowired
	private TiketService tiketService;
	@Autowired
	private UserService userService;
	public BookingDTO toDTO(Booking booking) {
		BookingDTO dto = new BookingDTO();
		dto.setId(booking.getId());
		dto.setBookingDate(booking.getBookingDate());
		dto.setShowDate(booking.getShowDate());
		dto.setTiket(booking.getTiket().getId());
		dto.setUser(booking.getUser().getId());
		return dto;
	}
	public List<BookingDTO> toDTOList(List<Booking> module) {
		return module.stream().map(e -> toDTO(e)).collect(Collectors.toList());

	}
	public Booking toModule(BookingDTO dto) {
		Booking module = new Booking();
		module.setId(dto.getId());
		module.setBookingDate(dto.getBookingDate());
		module.setShowDate(dto.getShowDate());
		module.setTiket(tiketService.getTiketById(dto.getTiket()));
		module.setUser(userService.getUserById(dto.getUser()));
		return module;
		
	}
}
