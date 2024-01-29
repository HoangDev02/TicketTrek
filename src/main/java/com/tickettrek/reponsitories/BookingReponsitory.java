package com.tickettrek.reponsitories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tickettrek.module.Booking;

public interface BookingReponsitory extends JpaRepository<Booking, Integer>{
//	Optional<Booking> findByIdAndUsername(Integer id, String username);
//	Optional<Booking> findByIdAndTicket(Integer id, Integer ticket);

}
