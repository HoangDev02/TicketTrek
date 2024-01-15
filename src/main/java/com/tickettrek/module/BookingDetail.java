package com.tickettrek.module;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "booking_detail")
public class BookingDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_detail_id")
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "tiket_id")
    private Tiket tiket;
	
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
