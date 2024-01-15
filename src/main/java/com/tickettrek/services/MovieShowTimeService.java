package com.tickettrek.services;

import com.tickettrek.module.MovieShowTime;

public interface MovieShowTimeService {
	MovieShowTime getAllById(Integer id);
	MovieShowTime getAll();
}
