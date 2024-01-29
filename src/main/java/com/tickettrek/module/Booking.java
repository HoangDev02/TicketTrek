package com.tickettrek.module;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "bookingDate")
	private Date bookingDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "showDate")
	private Date showDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String status;
	
	@OneToOne
	@JoinColumn(name = "tiket_id", unique = true)
	private Tiket tiket;
}
