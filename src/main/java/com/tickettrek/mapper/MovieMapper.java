package com.tickettrek.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tickettrek.dtos.MoviesDTO;
import com.tickettrek.module.Movie;

@Component
public class MovieMapper {
	public MoviesDTO toDto(Movie movie) {
		MoviesDTO dto = new MoviesDTO();
		dto.setCast(movie.getCast());
		dto.setTitle(movie.getTitle());
		dto.setDuration(movie.getDuration());
		dto.setReleaseDate(movie.getReleaseDate());
		dto.setDirector(movie.getDirector());
		dto.setGenre(movie.getGenre());
		dto.setProductionCompany(movie.getProductionCompany());
		dto.setProductionCountry(movie.getProductionCountry());
		dto.setProductionYear(movie.getProductionYear());
		dto.setFormat(movie.getFormat());
		dto.setLanguage(movie.getLanguage());
		dto.setPosterImage(movie.getPosterImage());
		dto.setTrailerLink(movie.getTrailerLink());
		return dto;
	}

	public List<MoviesDTO> toDTOList(List<Movie> models) {
		return models.stream().map(cat -> toDto(cat)).collect(Collectors.toList());
	}

	public Movie toModel(MoviesDTO dto) {
		Movie module = new Movie();
		module.setCast(dto.getCast());
		module.setTitle(dto.getTitle());
		module.setDuration(dto.getDuration());
		module.setReleaseDate(dto.getReleaseDate());
		module.setDirector(dto.getDirector());
		module.setGenre(dto.getGenre());
		module.setProductionCompany(dto.getProductionCompany());
		module.setProductionCountry(dto.getProductionCountry());
		module.setProductionYear(dto.getProductionYear());
		module.setFormat(dto.getFormat());
		module.setLanguage(dto.getLanguage());
		module.setPosterImage(dto.getPosterImage());
		module.setTrailerLink(dto.getTrailerLink());
		return module;
	}
}
