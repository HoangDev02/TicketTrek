package com.tickettrek.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesDTO {
	private int id;
	private String title;
	private int duration;
	private LocalDate releaseDate;
	private String director;
	private String cast;
	private String genre;
	private String productionCompany;
	private String productionCountry;
	private int productionYear;
	private String format;
	private String language;
	private String posterImage;
	private String trailerLink;
}
