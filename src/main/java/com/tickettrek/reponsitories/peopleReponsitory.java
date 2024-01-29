package com.tickettrek.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tickettrek.module.People;

public interface peopleReponsitory extends JpaRepository<People, Integer>{

}
