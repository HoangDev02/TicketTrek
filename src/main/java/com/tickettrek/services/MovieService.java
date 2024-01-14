package com.tickettrek.services;

import java.util.List;

import com.tickettrek.module.Movie;

public interface MovieService {
	Movie createMovies(Movie movie);
	List<Movie> getAllMovies();
	Movie findById(Integer id);
	void deleteMovieById(Integer id);
	Movie updateById(Integer id, Movie movie);
}
