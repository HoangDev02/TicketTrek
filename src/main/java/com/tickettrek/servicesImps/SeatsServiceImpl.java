package com.tickettrek.servicesImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickettrek.module.Seats;
import com.tickettrek.reponsitories.SeatsRepository;
import com.tickettrek.services.SeatsService;

@Service
public class SeatsServiceImpl implements SeatsService {

	@Autowired
	private SeatsRepository seatsRepository;

	@Override
	public Seats createSeats(Seats seat) {
		// TODO Auto-generated method stub
		return seatsRepository.save(seat);
	}

	@Override
	public Seats updateSeats(Integer id, Seats seat) {
		Seats existing = seatsRepository.findById(id).orElse(null);
		if (existing != null) {
			existing.setSeatNumber(seat.getSeatNumber());
			existing.setSeatType(seat.isSeatType());
			seatsRepository.save(existing);
		}
		return null;
	}

	@Override
	public void deleteSeats(Integer id) {
		seatsRepository.deleteById(id);

	}

	@Override
	public List<Seats> getAllSeats() {
		// TODO Auto-generated method stub
		return seatsRepository.findAll();
	}

	@Override
	public Seats getSeatsById(Integer id) {
		// TODO Auto-generated method stub
		return seatsRepository.findById(id).orElse(null);
	}

}
