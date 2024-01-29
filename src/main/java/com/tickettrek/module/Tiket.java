package com.tickettrek.module;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
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
@Table(name = "tikets")
public class Tiket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tiket_id")
	private int id;

	@Column(name = "price")
	private int price;

	@Column(name = "status")
	private boolean status;

//    @JsonBackReference
//    @OneToOne(mappedBy = "tikets")
//    private Seats seats;

	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "seat_id") // Define the foreign key column
	private Seats seats;

//    @JsonBackReference
	@OneToMany(mappedBy = "tiket")
	private List<PeopleDetail> peopleDetail;
	
	@JsonBackReference
	@OneToMany(mappedBy = "tiket",cascade = CascadeType.ALL)
	private List<Booking> booking;
//	
//	@OneToOne
//	@JoinColumn(name = "booking_id", unique = true)
//	private Booking booking;
}
