package com.tickettrek.services;

import java.util.List;

import com.tickettrek.module.AuditoriumShowTime;

public interface AuditoriumShowTimeService {
	AuditoriumShowTime getAllById(Integer id);
	List<AuditoriumShowTime> getAll();
	AuditoriumShowTime create(AuditoriumShowTime auditoriumShowTime);
}
