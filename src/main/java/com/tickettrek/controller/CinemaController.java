package com.tickettrek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tickettrek.dtos.CinemaDTO;
import com.tickettrek.mapper.CinemaMapper;
import com.tickettrek.module.Cinema;
import com.tickettrek.services.CinemaService;

@RestController
@RequestMapping("/api/cinema")
public class CinemaController {
	
	@Autowired
	private CinemaMapper cinemaMapper;
	@Autowired 
	private CinemaService cinemaService;
	
	@GetMapping
	public List<CinemaDTO> getAllCinemaById() {
		return cinemaMapper.toDTOList(cinemaService.getAllCinema());
	}
	@PostMapping("/create")
	public ResponseEntity<CinemaDTO> createCinema(@RequestBody CinemaDTO cinemaDTO) {
		Cinema cinema = cinemaMapper.toModule(cinemaDTO);
		cinemaService.createCinema(cinema);
		return ResponseEntity.ok(cinemaDTO);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<CinemaDTO> updateCinema(@PathVariable("id") Integer id, @RequestBody CinemaDTO cinemaDTO) {
		Cinema updateCinema = cinemaService.updateCinemaById(id, cinemaMapper.toModule(cinemaDTO));
		CinemaDTO updateDto = cinemaMapper.toDTO(updateCinema);
		return ResponseEntity.ofNullable(updateDto);	
	}
	@GetMapping("/{id}") 
	public ResponseEntity<CinemaDTO> getCinemaById(@PathVariable("id") Integer id) {
		Cinema updateCinema = cinemaService.getCinemaById(id);
		CinemaDTO updateDTO = cinemaMapper.toDTO(updateCinema);
		return ResponseEntity.ok(updateDTO);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCinema(@PathVariable("id") Integer id) {
		cinemaService.deleteCinema(id);
		 return ResponseEntity.noContent().build();
	}
}
