package com.tickettrek.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class BookingDTO {
	private Integer id;
	private Date bookingDate;
	private Date showDate;
	private Integer tiket;
	private Integer user;
}
