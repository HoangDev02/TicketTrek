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

import com.tickettrek.dtos.AuditoriumDTO;
import com.tickettrek.mapper.AuditoriumMapper;
import com.tickettrek.module.Auditorium;
import com.tickettrek.services.AuditoriumService;

@RestController
@RequestMapping("/api/auditorium")
public class AuditoriumController {
	
	@Autowired
	private AuditoriumService auditoriumService;
	@Autowired
	private AuditoriumMapper auditoriumMapper;
	
	@GetMapping
	public List<AuditoriumDTO>getAllCinema() {
		return auditoriumMapper.toDTOList(auditoriumService.getAllAuditorium());
	}
	@GetMapping("/{id}") 
	public ResponseEntity<AuditoriumDTO> getAuditoriumById(@PathVariable("id") Integer id) {
		Auditorium updateAuditorium = auditoriumService.getAuditoriumById(id);
		AuditoriumDTO updateDTO = auditoriumMapper.toDTO(updateAuditorium);
		return ResponseEntity.ok(updateDTO);
	}
	@PostMapping("/create")
	public AuditoriumDTO createAuditorium(@RequestBody AuditoriumDTO auditoriumDTO) {
		return auditoriumMapper.toDTO(auditoriumService.createAuditorium(auditoriumMapper.toModule(auditoriumDTO)));
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<AuditoriumDTO> updateAuditorium(@PathVariable("id") Integer id, @RequestBody AuditoriumDTO auditoriumDTO) {
		Auditorium updateService = auditoriumService.updateAuditorium(id, auditoriumMapper.toModule(auditoriumDTO));
		AuditoriumDTO updateDTo = auditoriumMapper.toDTO(updateService);
		return ResponseEntity.ofNullable(updateDTo);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAuditorium(@PathVariable("id") Integer id) {
		auditoriumService.deleteAuditorium(id);
		 return ResponseEntity.noContent().build();
	}
}
