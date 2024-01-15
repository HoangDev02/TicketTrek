package com.tickettrek.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tickettrek.module.Seats;

public interface SeatsRepository extends JpaRepository<Seats, Integer> {
    // Custom queries can be added here if needed
}