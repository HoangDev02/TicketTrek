package com.tickettrek.servicesImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickettrek.module.People;
import com.tickettrek.reponsitories.peopleReponsitory;
import com.tickettrek.services.PeopleService;

@Service
public class PeopleServiceImp implements PeopleService{
	@Autowired
	private peopleReponsitory peopleReponsitory;
	@Override
	public People createPeoPle(People people) {
		// TODO Auto-generated method stub
		return peopleReponsitory.save(people);
	}

	@Override
	public List<People> getAllPeoPle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public People getPeopleById(Integer id) {
		// TODO Auto-generated method stub
		return peopleReponsitory.findById(id).orElse(null);
	}

}
