package com.tickettrek.dtos;

import java.util.List;

import com.tickettrek.module.BookingDetail;
import com.tickettrek.module.PeopleDetail;

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
//	private List<PeopleDetail> peopleDetail;
//	private List<BookingDetail> bookingDetail;
}
