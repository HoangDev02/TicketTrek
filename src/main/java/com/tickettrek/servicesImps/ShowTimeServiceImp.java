package com.tickettrek.servicesImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tickettrek.module.ShowTime;
import com.tickettrek.reponsitories.ShowTimeRoponsitory;
import com.tickettrek.services.ShowTimeService;

public class ShowTimeServiceImp implements ShowTimeService {

	@Autowired
	private ShowTimeRoponsitory showTimeRoponsitory;

	@Override
	public ShowTime createShowTime(ShowTime showTime) {
		// TODO Auto-generated method stub
		return showTimeRoponsitory.save(showTime);
	}

	@Override
	public ShowTime update(Integer id, ShowTime showTime) {
		ShowTime existing = showTimeRoponsitory.findById(id).orElse(null);
		if (existing != null) {
			existing.setShowDateTime(showTime.getShowDateTime());
			return showTimeRoponsitory.save(existing);
		}else {
			return null;
		}
	}

	@Override
	public ShowTime getShowTimeById(Integer id) {
		// TODO Auto-generated method stub
		return showTimeRoponsitory.findById(id).orElse(null);
	}

	@Override
	public List<ShowTime> getAllShowTime() {
		// TODO Auto-generated method stub
		return showTimeRoponsitory.findAll();
	}

	@Override
	public Integer getAuditoriumIdByShowTimeId(Integer id) {
		// TODO Auto-generated method stub
		return showTimeRoponsitory.findAuditoriumIdByShowTimeId(id);
	}

}
