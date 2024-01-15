package com.tickettrek.servicesImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickettrek.module.Tiket;
import com.tickettrek.reponsitories.TiketRepository;
import com.tickettrek.services.TiketService;

@Service
public class TiketServiceImpl implements TiketService {

	@Autowired
	private TiketRepository tiketRepository;

	@Override
	public Tiket createTiket(Tiket tiket) {
		// TODO Auto-generated method stub
		return tiketRepository.save(tiket);
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
