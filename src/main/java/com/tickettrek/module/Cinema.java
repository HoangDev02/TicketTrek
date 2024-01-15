package com.tickettrek.module;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cinemas")
public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cinema_id")
	private Integer id;

	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private int phone;
	
	@Column(name = "number_of_auditoriums")
	private int auditoriums;
	
	@Column(name = "image")
	private String image;
	
	@JsonBackReference()
	@OneToMany(mappedBy = "cinema")
	private List<Auditorium> auditorium;
}
