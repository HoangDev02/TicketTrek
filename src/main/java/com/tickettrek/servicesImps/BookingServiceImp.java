package com.tickettrek.servicesImps;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickettrek.module.Booking;
import com.tickettrek.module.Tiket;
import com.tickettrek.module.User;
import com.tickettrek.reponsitories.BookingReponsitory;
import com.tickettrek.reponsitories.TiketRepository;
import com.tickettrek.services.BookingService;
import com.tickettrek.services.UserService;

@Service
public class BookingServiceImp implements BookingService {

	@Autowired
	private BookingReponsitory bookingReponsitory;
	@Autowired
	private TiketRepository tiketRepository;
	@Autowired
	private UserService userService;

	@Override
	public Booking createBooking(Booking booking, Integer userId, Integer tiketId) {
		Tiket tiket = tiketRepository.findById(tiketId).orElseThrow(() -> new RuntimeException("Ticket not found"));
		if (tiket.isStatus()) {
			throw new RuntimeException("Ticket is already booked");
		}
		tiket.setStatus(true);
		tiketRepository.save(tiket);

		User user = userService.getUserById(userId);
		if (user == null) {
			throw new RuntimeException("User not found");
		}

		booking.setUser(user);
		booking.setTiket(tiket);
		return bookingReponsitory.save(booking);
	}

	@Override
	public Booking getBookingById(Integer id) {
		// TODO Auto-generated method stub
		return bookingReponsitory.findById(id).orElse(null);
	}

	@Override
	public Optional<Booking> getBookingByIdUser(Integer id) {
		return null;
		// TODO Auto-generated method stub
//		return bookingReponsitory.findByIdUsername(id);
	}

	@Override
	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		return bookingReponsitory.findAll();
	}

	@Override
	public Optional<Booking> getBookingByIdTicket(Integer id) {
		return null;
		// TODO Auto-generated method stub
//		return bookingReponsitory.findByIdTicket(id);
	}

	@Override
	public Booking updateBooking(Integer id, Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBooking(Integer id, Integer tiketId) {
		Tiket tiket = tiketRepository.findById(tiketId).orElseThrow(() -> new RuntimeException("Ticket not found"));
		tiket.setStatus(false);
		tiketRepository.save(tiket);
		bookingReponsitory.deleteById(id);
	}

}
