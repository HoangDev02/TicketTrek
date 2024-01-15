package com.tickettrek.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tickettrek.module.Booking;

public interface BookingReponsitory extends JpaRepository<Booking, Integer>{

}
