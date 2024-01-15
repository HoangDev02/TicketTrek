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

import com.tickettrek.dtos.SeatsDTO;
import com.tickettrek.mapper.SeatsMapper;
import com.tickettrek.module.Seats;
import com.tickettrek.services.SeatsService;

@RestController
@RequestMapping("/api/seats")
public class SeatsController {
	   @Autowired
	    private SeatsService seatsService;

	    @Autowired
	    private SeatsMapper seatsMapper;

	    @GetMapping("/{id}")
	    public ResponseEntity<SeatsDTO> getSeatsById(@PathVariable("id") Integer id) {
	        Seats seats = seatsService.getSeatsById(id);
	        if (seats != null) {
	            SeatsDTO seatsDTO = seatsMapper.toDTO(seats);
	            return ResponseEntity.ok(seatsDTO);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<SeatsDTO>> getAllSeats() {
	        List<Seats> seatsList = seatsService.getAllSeats();
	        List<SeatsDTO> seatsDTOList = seatsMapper.toDTOList(seatsList);
	        return ResponseEntity.ok(seatsDTOList);
	    }

	    @PostMapping("create")
	    public ResponseEntity<SeatsDTO> createSeats(@RequestBody SeatsDTO seatsDTO) {
	        Seats seats = seatsMapper.toModule(seatsDTO);
	        seats = seatsService.createSeats(seats);
	        SeatsDTO createdSeatsDTO = seatsMapper.toDTO(seats);
	        return ResponseEntity.ok(createdSeatsDTO);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Void> updateSeats(@PathVariable("id") Integer id, @RequestBody SeatsDTO seatsDTO) {
	        Seats seats = seatsMapper.toModule(seatsDTO);
	        seatsService.updateSeats(id, seats);
	        return ResponseEntity.noContent().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteSeats(@PathVariable("id") Integer id) {
	        seatsService.deleteSeats(id);
	        return ResponseEntity.noContent().build();
	    }
}
