package com.tickettrek.services;

import java.util.List;

import com.tickettrek.module.Auditorium;

public interface AuditoriumService {
	List<Auditorium> getAllAuditorium();
	Auditorium getAuditoriumById(Integer id);
	Auditorium createAuditorium(Auditorium auditorium);
	Auditorium updateAuditorium(Integer id, Auditorium auditorium);
	void deleteAuditorium(Integer id);
}
