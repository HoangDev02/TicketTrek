package com.tickettrek.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class tiketDTO {
	private Integer id;
	private int price;
	private boolean status;
	private int seats;
	private int peopleId;

}
