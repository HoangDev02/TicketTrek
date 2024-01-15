package com.tickettrek.servicesImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tickettrek.module.AuditoriumShowTime;
import com.tickettrek.reponsitories.AuditoriumShowTimeReponsitory;
import com.tickettrek.services.AuditoriumShowTimeService;

public class AuditoriumShowTimeServiceImp implements AuditoriumShowTimeService{
	@Autowired
	private AuditoriumShowTimeReponsitory auditoriumShowTimeReponsitory;
	@Override
	public AuditoriumShowTime getAllById(Integer id) {
		// TODO Auto-generated method stub
		return auditoriumShowTimeReponsitory.findById(id).orElse(null);
	}

	@Override
	public List<AuditoriumShowTime> getAll() {
		// TODO Auto-generated method stub
		return auditoriumShowTimeReponsitory.findAll();
	}

	@Override
	public AuditoriumShowTime create(AuditoriumShowTime auditoriumShowTime) {
		// TODO Auto-generated method stub
		return auditoriumShowTimeReponsitory.save(auditoriumShowTime);
	}
}
