package com.esprit.td.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esprit.td.entities.User;
import com.esprit.td.repositories.AccountRepository;
import com.esprit.td.repositories.UserRepository;
import com.esprit.td.requests.PasswordRequest;
import com.esprit.td.responses.MessageResponse;
import com.esprit.td.services.UserService;





@Service
public class UserServicesImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountRepository contactRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	

	public MessageResponse save(User user) {

		boolean exist = contactRepository.existsByEmail(user.getEmail());

		if (exist) {

			return new MessageResponse(false, "Attention", "Email exist deja");

		}

		exist = userRepository.existsByUsername(user.getUsername());

		if (exist) {

			return new MessageResponse(false, "Attention", "Username exist deja");

		}

		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);

		userRepository.save(user);
		return new MessageResponse(true, "success", "operation effectuee");

	}

	@Transactional
	@Override
	

	public MessageResponse update(User user) {
		boolean exist = contactRepository.existsByEmailAndId(user.getEmail(), user.getId());

		if (!exist) {
			exist = contactRepository.existsByEmail(user.getEmail());
			if (exist) {
				return new MessageResponse(false, "Attention", "Email exist deja");
			}
		}

		exist = userRepository.existsByUsernameAndId(user.getUsername(), user.getId());

		if (!exist) {
			exist = contactRepository.existsByEmail(user.getUsername());
			if (exist) {
				return new MessageResponse(false, "Attention", "Username exist deja");
			}
		}
		userRepository.save(user);
		return new MessageResponse(true, "success", "update effectuee");
	}

	@Transactional
	@Override
	public MessageResponse delete(Integer id) {
		User user = findById(id);
		if (user == null) {
			return new MessageResponse(false, "Attention", "utilisateur n'existe pas");
		}

		// userRepository.deleteById(id);
		userRepository.delete(user);
		return new MessageResponse(true, "success", "delete effectuee");
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}
    @Transactional
	@Override
	public MessageResponse changePassword(PasswordRequest passwordRequest) {
    	User user = userRepository.findByUsername(passwordRequest.getUsername());
    	if(user == null) {
			return new MessageResponse(false, "Attention", "utilisateur n'existe pas");
    	}
    	
    	boolean matched = passwordEncoder.matches(passwordRequest.getOldPassword(), user.getPassword());
    	if(!matched) {
			return new MessageResponse(false, "Attention", "password not matched");

    	}
    	
    	
    	String encoderPassword = passwordEncoder.encode(passwordRequest.getNewPassword());
    	user.setPassword(encoderPassword);
    	userRepository.save(user);
    	
		return new MessageResponse(true, "success", "update password effectuee");
	}

	
}
