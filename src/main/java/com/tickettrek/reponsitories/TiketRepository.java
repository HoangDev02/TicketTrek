package com.tickettrek.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tickettrek.module.Tiket;

public interface TiketRepository extends JpaRepository<Tiket, Integer>{

}
