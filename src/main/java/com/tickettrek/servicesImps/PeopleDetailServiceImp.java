package com.tickettrek.servicesImps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickettrek.module.PeopleDetail;
import com.tickettrek.reponsitories.PeopleDetailRepository;
import com.tickettrek.services.PeopleDetailService;

@Service
public class PeopleDetailServiceImp implements PeopleDetailService{
	
	@Autowired
	private PeopleDetailRepository detailRepository;

	@Override
	public PeopleDetail create(PeopleDetail peopleDetail) {
		// TODO Auto-generated method stub
		return detailRepository.save(peopleDetail);
	}

}
