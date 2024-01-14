package com.tickettrek.servicesImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickettrek.module.Movie;
import com.tickettrek.reponsitories.MovieReponsitory;
import com.tickettrek.services.MovieService;

@Service
public class MovieServiceImp implements MovieService{
	
	@Autowired
	private MovieReponsitory movieReponsitory;
	@Override
	public Movie createMovies(Movie movie) {
		// TODO Auto-generated method stub
		return movieReponsitory.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieReponsitory.findAll();
	}

	@Override
	public Movie findById(Integer id) {
		// TODO Auto-generated method stub
		return movieReponsitory.findById(id).orElse(null);
	}

	@Override
	public void deleteMovieById(Integer id) {
		movieReponsitory.deleteById(id);
		
	}

	@Override
	public Movie updateById(Integer id, Movie movie) {
		// TODO Auto-generated method stub
		return movieReponsitory.findById(id).map(e -> {
			e.setCast(movie.getCast());
			e.setDirector(movie.getDirector());
			e.setTitle(movie.getTitle());
			e.setDuration(movie.getDuration());
			e.setGenre(movie.getGenre());
			return movieReponsitory.save(e);
		}).orElse(null);
	}



}
