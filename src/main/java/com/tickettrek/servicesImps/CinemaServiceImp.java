package com.tickettrek.servicesImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tickettrek.module.Cinema;
import com.tickettrek.reponsitories.CinemaReponsitory;
import com.tickettrek.services.CinemaService;

@Service
public class CinemaServiceImp implements CinemaService{
	
	@Autowired
	private CinemaReponsitory cinemaReponsitory;
	
	@Override
	public Cinema createCinema(Cinema cinema) {
		// TODO Auto-generated method stub
		return cinemaReponsitory.save(cinema);
	}

	@Override
	public List<Cinema> getAllCinema() {
		// TODO Auto-generated method stub
		return cinemaReponsitory.findAll();
	}

	@Override
	public Cinema getCinemaById(Integer id) {
		// TODO Auto-generated method stub
		return cinemaReponsitory.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cinema not found"));
	}

	@Override
	public Cinema updateCinemaById(Integer id, Cinema cinema) {
		Cinema existingCinema = cinemaReponsitory.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "update fail"));
		if(existingCinema != null) {
			existingCinema.setAddress(cinema.getAddress());
			existingCinema.setName(cinema.getName());
			existingCinema.setImage(cinema.getImage());
//			existingCinema.setAuditorium(cinema.getAuditorium());
			existingCinema.setPhone(cinema.getPhone());
			return cinemaReponsitory.save(existingCinema);
		}
		return null;
	}

	@Override
	public void deleteCinema(Integer id) {
		cinemaReponsitory.deleteById(id);
		
	}

}
