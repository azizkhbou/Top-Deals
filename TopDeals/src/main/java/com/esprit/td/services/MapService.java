package com.esprit.td.services;

import java.util.List;

import com.esprit.td.entities.Map;
import com.esprit.td.requests.PasswordRequest;
import com.esprit.td.responses.MessageResponse;

public interface MapService {
	
	
	List<Map> retrieveAllMaps();
	Map addMap(Map m);
	void deleteMap(int idMap);
	Map updateMap(Map m);

}
