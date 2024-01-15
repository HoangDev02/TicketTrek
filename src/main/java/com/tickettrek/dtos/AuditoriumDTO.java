package com.tickettrek.dtos;

import lombok.Data;

@Data
public class AuditoriumDTO {
	private Integer id;
	private String name;
	private int numberOfRows;
	private int numberOfColumns;
	private Integer cinemaId;
}
