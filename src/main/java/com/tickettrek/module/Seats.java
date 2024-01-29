package com.tickettrek.module;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "seats")
public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Integer id;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "seat_type")
    private boolean seatType;

    @JsonBackReference
    @OneToOne(mappedBy = "seats")
    private Tiket tikets;
    
    @ManyToOne
    @JoinColumn(name = "auditorium_id")
    private Auditorium auditorium;
}
