package com.tickettrek.services;

import java.util.List;

import com.tickettrek.module.Tiket;

public interface TiketService {
	Tiket createTiket(Tiket tiket, int peopleId);

	Tiket updateTiket(int id, Tiket tiket);

	void deleteTiket(int id);

	List<Tiket> getAllTikets();

	Tiket getTiketById(int id);
}
