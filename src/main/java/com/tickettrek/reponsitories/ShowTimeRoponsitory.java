package com.tickettrek.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tickettrek.module.ShowTime;

public interface ShowTimeRoponsitory extends JpaRepository<ShowTime,Integer >{

}
