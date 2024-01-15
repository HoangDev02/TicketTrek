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

import com.tickettrek.dtos.tiketDTO;
import com.tickettrek.mapper.tiketMapper;
import com.tickettrek.module.Tiket;
import com.tickettrek.services.TiketService;

@RestController
@RequestMapping("/api/ticket")
public class TiketController {
	@Autowired
	private TiketService tiketService;

	@Autowired
	private tiketMapper tiketMapper;

	@GetMapping("/{id}")
	public ResponseEntity<tiketDTO> getTiketById(@PathVariable Integer id) {
		Tiket tiket = tiketService.getTiketById(id);
		if (tiket != null) {
			tiketDTO tiketDTO = tiketMapper.toDTO(tiket);
			return ResponseEntity.ok(tiketDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public List<tiketDTO> getAllTikets() {
		return tiketMapper.toDTOList(tiketService.getAllTikets());
	}

	@PostMapping("/create")
	public ResponseEntity<tiketDTO> createTiket(@RequestBody tiketDTO tiketDTO) {
		Tiket tiket = tiketMapper.toModule(tiketDTO);
		tiket = tiketService.createTiket(tiket);
		tiketDTO createdTiketDTO = tiketMapper.toDTO(tiket);
		return ResponseEntity.ok(createdTiketDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateTiket(@PathVariable int id, @RequestBody tiketDTO tiketDTO) {
		Tiket tiket = tiketMapper.toModule(tiketDTO);
		tiketService.updateTiket(id, tiket);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTiket(@PathVariable int id) {
		tiketService.deleteTiket(id);
		return ResponseEntity.noContent().build();
	}
}
