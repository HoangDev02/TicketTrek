package com.tickettrek.servicesImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tickettrek.module.Auditorium;
import com.tickettrek.reponsitories.AuditoriumReponsitory;
import com.tickettrek.services.AuditoriumService;

@Service
public class AuditoriumServiceImp implements AuditoriumService{
	
	@Autowired
	private AuditoriumReponsitory auditoriumReponsitory;
	
	@Override
	public List<Auditorium> getAllAuditorium() {
		// TODO Auto-generated method stub
		return auditoriumReponsitory.findAll();
	}

	@Override
	public Auditorium getAuditoriumById(Integer id) {
		// TODO Auto-generated method stub
		return auditoriumReponsitory.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "auditorium not found"));
	}

	@Override
	public Auditorium createAuditorium(Auditorium auditorium) {
		// TODO Auto-generated method stub
		return auditoriumReponsitory.save(auditorium);
	}

	@Override
	public Auditorium updateAuditorium(Integer id, Auditorium auditorium) {
		Auditorium existingAuditorium = auditoriumReponsitory.findById(id).orElse(null);
		if(existingAuditorium != null) {
			existingAuditorium.setName(auditorium.getName());
			existingAuditorium.setNumberOfColumns(auditorium.getNumberOfColumns());
			existingAuditorium.setNumberOfRows(auditorium.getNumberOfRows());
			auditoriumReponsitory.save(existingAuditorium);
		}
		return null;
	}

	@Override
	public void deleteAuditorium(Integer id) {
		auditoriumReponsitory.findById(id);
		
	}

}
