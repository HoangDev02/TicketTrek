package com.tickettrek.module;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "auditoriums")
public class Auditorium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditorium_id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "number_of_rows")
	private String numberOfRows;

	@Column(name = "number_of_columns")
	private String numberOfColumns;

	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "cinema_id")
	private Cinema cinema;

	@JsonBackReference
	@OneToMany(mappedBy = "auditorium")
	private List<AuditoriumShowTime> auditoriumShowTime;

	@JsonBackReference
	@OneToMany(mappedBy = "auditorium")
	private List<Seats> seats;
}
