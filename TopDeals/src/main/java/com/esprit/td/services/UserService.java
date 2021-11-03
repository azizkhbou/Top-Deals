package com.esprit.td.services;

import java.util.List;

import com.esprit.td.entities.User;
import com.esprit.td.requests.PasswordRequest;
import com.esprit.td.responses.MessageResponse;



public interface UserService {
	
	
	public MessageResponse save(User user);
	public MessageResponse update(User user);
	public MessageResponse delete(Integer id);
	public List<User> findAll();
	public User findById(Integer id);
    public MessageResponse changePassword(PasswordRequest passwordRequest);

}
