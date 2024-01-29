package com.tickettrek.servicesImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickettrek.module.People;
import com.tickettrek.module.PeopleDetail;
import com.tickettrek.module.PeopleDetailId;
import com.tickettrek.module.Tiket;
import com.tickettrek.reponsitories.PeopleDetailRepository;
import com.tickettrek.reponsitories.TiketRepository;
import com.tickettrek.reponsitories.peopleReponsitory;
import com.tickettrek.services.PeopleDetailService;
import com.tickettrek.services.PeopleService;
import com.tickettrek.services.TiketService;

@Service
public class TiketServiceImpl implements TiketService {

	@Autowired
	private TiketRepository tiketRepository;
	@Autowired
	private peopleReponsitory peopleReponsitory;
//	@Autowired
//	private PeopleDetailRepository peopleDetailRepository;
	@Autowired
	private PeopleDetailService peopleDetailService;
	@Override
	public Tiket createTiket(Tiket tiket, int peopleId) {
	    Tiket savedTiket = tiketRepository.save(tiket);

	    People people = peopleReponsitory.findById(peopleId).orElse(null);
	    System.out.println("people" + people);
	    if (people != null) {
	        PeopleDetail peopleDetail = new PeopleDetail();
	        PeopleDetailId peopleDetailId = new PeopleDetailId();
	        peopleDetailId.setTiketId(savedTiket.getId());
	        peopleDetailId.setPeopleId(people.getId());
	        
	        peopleDetail.setId(peopleDetailId);
	        peopleDetail.setPeople(people);
	        peopleDetail.setTiket(savedTiket);

	        // Save PeopleDetail
	        peopleDetailService.create(peopleDetail);
	        
	        return savedTiket;
	    } else {
	        throw new IllegalArgumentException("People not found with ID: " + people);
	    }
	}




	@Override
	public Tiket updateTiket(int id, Tiket tiket) {
		Tiket existingTiket = tiketRepository.findById(id).orElse(null);
		if (existingTiket != null) {
			existingTiket.setPrice(tiket.getPrice());
			existingTiket.setStatus(tiket.isStatus());
			tiketRepository.save(existingTiket);
		}
		return null;
	}

	@Override
	public void deleteTiket(int id) {
		tiketRepository.deleteById(id);
	}

	@Override
	public List<Tiket> getAllTikets() {
		// TODO Auto-generated method stub
		return tiketRepository.findAll();
	}

	@Override
	public Tiket getTiketById(int id) {
		return tiketRepository.findById(id).orElse(null);
	}

}
