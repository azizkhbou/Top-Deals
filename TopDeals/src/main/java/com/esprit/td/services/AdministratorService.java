package com.esprit.td.services;

import java.util.List;

import com.esprit.td.entities.Administrator;
import com.esprit.td.requests.PasswordRequest;
import com.esprit.td.responses.MessageResponse;



public interface AdministratorService {
	
	
	public MessageResponse save(Administrator administrator);
	public MessageResponse update(Administrator administrator);
	public MessageResponse delete(Integer id);
	public List<Administrator> findAll();
	public Administrator findById(Integer id);
    public MessageResponse changePassword(PasswordRequest passwordRequest);

}
