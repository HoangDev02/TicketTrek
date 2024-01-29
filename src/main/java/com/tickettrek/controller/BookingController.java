package com.tickettrek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tickettrek.configs.CustomUserDetails;
import com.tickettrek.dtos.BookingDTO;
import com.tickettrek.mapper.BookingMapper;
import com.tickettrek.module.Booking;
import com.tickettrek.services.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@Autowired
	private BookingMapper bookingMapper;

	@PostMapping("/create")
	public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			CustomUserDetails currentUserDetails = (CustomUserDetails) authentication.getPrincipal();
			Integer userId = currentUserDetails.getUser().getId();
			Integer tiketId = bookingDTO.getTiket();

			Booking booking = bookingMapper.toModule(bookingDTO);
			Booking createdBooking = bookingService.createBooking(booking, userId, tiketId);

			return ResponseEntity.ok(bookingMapper.toDTO(createdBooking));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable("id") Integer id, @RequestParam("tiket") Integer tiketId) {
//		try {
			bookingService.deleteBooking(id, tiketId);
			return ResponseEntity.ok("Booking deleted successfully");
//		} catch (RuntimeException e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//		}
	}

}
