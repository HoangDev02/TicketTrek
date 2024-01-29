package com.tickettrek.module;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp showDateTime;

	@ManyToOne
	@JoinColumn(name = "auditorium_id")
	private Auditorium auditorium;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
}
