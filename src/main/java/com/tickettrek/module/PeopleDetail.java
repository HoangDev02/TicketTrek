package com.tickettrek.module;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "people_detail")
public class PeopleDetail {
	@EmbeddedId
	private PeopleDetailId id;

	@MapsId("tiketId")
	@ManyToOne
	@JoinColumn(name = "tiket_id")
	private Tiket tiket;

	@MapsId("peopleId")
	@ManyToOne
	@JoinColumn(name = "people_id")
	private People people;
}