package com.tickettrek.services;

import java.util.List;

import com.tickettrek.module.ShowTime;

public interface ShowTimeService {
	ShowTime createShowTime(ShowTime showTime);
	ShowTime update(Integer id,ShowTime showTime);
	ShowTime getShowTimeById(Integer id);
	List<ShowTime> getAllShowTime();
	Integer  getAuditoriumIdByShowTimeId(Integer id);
}
