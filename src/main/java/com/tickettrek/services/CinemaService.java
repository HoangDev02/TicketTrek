package com.tickettrek.services;

import java.util.List;

import com.tickettrek.module.Cinema;

public interface CinemaService {
	Cinema createCinema(Cinema cinema);
	List<Cinema> getAllCinema();
	Cinema getCinemaById(Integer id);
	Cinema updateCinemaById(Integer id, Cinema cinema);
	void deleteCinema (Integer id);
}
