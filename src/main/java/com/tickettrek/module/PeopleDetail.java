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
@Table(name = "people_detail")
public class PeopleDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "people_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "tiket_id")
	private Tiket tiket;

	@ManyToOne
	@JoinColumn(name = "people_id", insertable = false, updatable = false)
	private People people;
}
