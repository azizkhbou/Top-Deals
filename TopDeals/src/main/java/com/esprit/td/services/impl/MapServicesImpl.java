package com.esprit.td.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esprit.td.entities.Map;
import com.esprit.td.entities.Notification;
import com.esprit.td.repositories.DealRepository;
import com.esprit.td.repositories.MapRepository;
import com.esprit.td.repositories.NotificationRepository;
import com.esprit.td.requests.PasswordRequest;
import com.esprit.td.responses.MessageResponse;
import com.esprit.td.services.MapService;

@Service
public class MapServicesImpl implements MapService {

	@Autowired
	private MapRepository mapRepository;

	@Override
	public List<Map> retrieveAllMaps() {
		return (List<Map>) (mapRepository.findAll());
	}

	@Override
	public Map addMap(Map m) {
		mapRepository.save(m);
		return m;
	}

	@Override
	public void deleteMap(int idMap) {
		mapRepository.deleteById(idMap);
		
	}

	@Override
	public Map updateMap(Map m) {
		mapRepository.save(m);
		return m;
	}

	

	



	
}
