package com.tickettrek.services;

import java.util.List;
import java.util.Optional;

import com.tickettrek.module.Booking;

public interface BookingService {
	Booking createBooking(Booking booking, Integer userId, Integer tiketId);
	Booking getBookingById(Integer id);
	Optional<Booking> getBookingByIdUser(Integer id);
	List<Booking> getAllBooking();
	Optional<Booking> getBookingByIdTicket(Integer id);
	Booking updateBooking(Integer id, Booking booking);
	void deleteBooking(Integer id, Integer tiketId);
	
}
