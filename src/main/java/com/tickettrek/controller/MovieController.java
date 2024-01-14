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

import com.tickettrek.dtos.MoviesDTO;
import com.tickettrek.mapper.MovieMapper;
import com.tickettrek.module.Movie;
import com.tickettrek.services.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired MovieMapper movieMapper;
	
	@GetMapping
	public List<MoviesDTO> getAllMovie() {
		return movieMapper.toDTOList(movieService.getAllMovies());
	}
	@PostMapping("/create")
	public ResponseEntity<String> createMovie(@RequestBody MoviesDTO moviesDTO) {
		Movie movie = movieMapper.toModel(moviesDTO);
		movieService.createMovies(movie);
		return ResponseEntity.ok("Create movie Success");
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<MoviesDTO> updateMovie(@PathVariable("id") Integer id, @RequestBody MoviesDTO moviesDTO) {
		
		Movie updateMovie = movieService.updateById(id, movieMapper.toModel(moviesDTO));
		MoviesDTO updateDto = movieMapper.toDto(updateMovie);
		return ResponseEntity.ok(updateDto);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<MoviesDTO> deleteCategory(@PathVariable("id") Integer id) {
	    
	    movieService.deleteMovieById(id);
		return ResponseEntity.noContent().build();
	}
}
