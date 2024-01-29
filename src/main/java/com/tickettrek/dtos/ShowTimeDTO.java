package com.tickettrek.dtos;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ShowTimeDTO {
	private Integer id;
	private Timestamp showDateTime;
	private Integer auditoriumId;
	private int movie;
}
