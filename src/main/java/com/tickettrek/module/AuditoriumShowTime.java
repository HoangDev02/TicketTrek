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
@Table(name = "auditorium_ShowTime")
public class AuditoriumShowTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditorium_ShowTime_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "showtime_id")
	private ShowTime showtime;

	@ManyToOne
	@JoinColumn(name = "auditorium_id")
	private Auditorium auditorium;

}
