package com.tickettrek.dtos;

import lombok.Data;

@Data
public class CinemaDTO {
	private Integer id;
	private String name;
	private String address;
	private String image;
	private int phone;
//	private int auditoriumsId;
}
