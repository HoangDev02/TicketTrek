package com.tickettrek.services;

import java.util.List;

import com.tickettrek.module.People;

public interface PeopleService {
	People createPeoPle(People people);
	List<People> getAllPeoPle();
	People getPeopleById(Integer id);
}
