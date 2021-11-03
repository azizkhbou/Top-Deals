package com.esprit.td.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.td.entities.Deal;
import com.esprit.td.repositories.DealRepository;
import com.esprit.td.services.DealService;

@Service
public class DealServiceImpl implements DealService{
	
	@Autowired
	private DealRepository dealRepository;

	@Override
	public List<Deal> retrieveAllDeals() {
		return (List<Deal>) (dealRepository.findAll());

	}

	@Override
	public Deal addDeal(Deal d) {
		dealRepository.save(d);
		return d;
	}

	@Override
	public void deleteDeal(int idDeal) {
		dealRepository.deleteById(idDeal);
		
	}

	@Override
	public Deal updateDeal(Deal d) {
		dealRepository.save(d);
		return d;
	}
	
	

}
