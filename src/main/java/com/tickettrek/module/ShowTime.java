package com.tickettrek.module;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "show_time")
public class ShowTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "showtime_id")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp showDateTime;

	@JsonBackReference
	@OneToMany(mappedBy = "showtime")
	private List<AuditoriumShowTime> auditoriumShowTime;

	@JsonBackReference
	@OneToMany(mappedBy = "showtime")
	private List<MovieShowTime> movieShowTime;
}
