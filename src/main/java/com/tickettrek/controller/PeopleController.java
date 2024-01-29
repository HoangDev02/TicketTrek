package com.tickettrek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tickettrek.dtos.PeopleDTO;
import com.tickettrek.mapper.PeopleMapper;
import com.tickettrek.module.People;
import com.tickettrek.services.PeopleService;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
	@Autowired
	private PeopleService peopleService;
	@Autowired
	private PeopleMapper peopleMapper;
	
	@PostMapping("/create")
	public ResponseEntity<String> CreatePeople(@RequestBody PeopleDTO peopleDTO) {
		People create = peopleMapper.toModule(peopleDTO);
		peopleService.createPeoPle(create);
		return ResponseEntity.ok("create success");
	}
	
	@GetMapping("/{id}")
	public PeopleDTO getPeopleById(@PathVariable Integer id) {
		return peopleMapper.toDTO(peopleService.getPeopleById(id));
	}
}
