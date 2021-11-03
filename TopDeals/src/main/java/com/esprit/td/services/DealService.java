package com.esprit.td.services;

import java.util.List;

import com.esprit.td.entities.Deal;
import com.esprit.td.entities.Map;

public interface DealService {
	
	List<Deal> retrieveAllDeals();
	Deal addDeal(Deal d);
	void deleteDeal(int idDeal);
	Deal updateDeal(Deal d);

}
