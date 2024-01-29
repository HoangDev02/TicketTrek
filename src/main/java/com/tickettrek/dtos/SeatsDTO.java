package com.tickettrek.dtos;

import lombok.Data;

@Data
public class SeatsDTO {
	private Integer id;
	private int seatNumber;
	private boolean seatType;
//	private int tiketId;
	private int auditoriumId;
}
