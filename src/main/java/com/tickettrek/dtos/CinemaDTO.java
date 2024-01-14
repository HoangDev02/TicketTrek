package com.tickettrek.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaDTO {
	private String name;
	private String address;
	private String image;
	private int phone;
}
