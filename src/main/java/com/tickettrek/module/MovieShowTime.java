package com.tickettrek.module;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "movie_showTime")
public class MovieShowTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditorium_ShowTime_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "showtime_id")
	private ShowTime showtime;

	@ManyToOne
	@JoinColumn(name = "movie_id") // Ensure this matches the actual column name in the 'movies' table
	private Movie movie;
}
