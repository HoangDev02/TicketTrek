package com.tickettrek.services;

import java.util.List;

import com.tickettrek.module.Seats;

public interface SeatsService {
    Seats createSeats(Seats seat);
    Seats updateSeats(Integer id, Seats seat);
    void deleteSeats(Integer id);
    List<Seats> getAllSeats();
    Seats getSeatsById(Integer id);
}