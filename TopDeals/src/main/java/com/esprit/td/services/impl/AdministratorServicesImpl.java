package com.esprit.td.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esprit.td.entities.Administrator;
import com.esprit.td.repositories.AccountRepository;
import com.esprit.td.repositories.AdministratorRepository;
import com.esprit.td.requests.PasswordRequest;
import com.esprit.td.responses.MessageResponse;
import com.esprit.td.services.AdministratorService;



@Service
public class AdministratorServicesImpl implements AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	@Secured("ROLE_ADMIN")
	public MessageResponse save(Administrator administrator) {

		boolean exist = accountRepository.existsByEmail(administrator.getEmail());

		if (exist) {

			return new MessageResponse(false, "Attention", "Email exist deja");

		}

		exist = administratorRepository.existsByUsername(administrator.getUsername());

		if (exist) {

			return new MessageResponse(false, "Attention", "Username exist deja");

		}

		String encodePassword = passwordEncoder.encode(administrator.getPassword());
		administrator.setPassword(encodePassword);

		administratorRepository.save(administrator);
		return new MessageResponse(true, "success", "operation effectuee");

	}

	@Transactional
	@Override
	@Secured("ROLE_ADMIN")

	public MessageResponse update(Administrator administrator) {
		boolean exist = accountRepository.existsByEmailAndId(administrator.getEmail(), administrator.getId());

		if (!exist) {
			exist = accountRepository.existsByEmail(administrator.getEmail());
			if (exist) {
				return new MessageResponse(false, "Attention", "Email exist deja");
			}
		}

		exist = administratorRepository.existsByUsernameAndId(administrator.getUsername(), administrator.getId());

		if (!exist) {
			exist = accountRepository.existsByEmail(administrator.getUsername());
			if (exist) {
				return new MessageResponse(false, "Attention", "Username exist deja");
			}
		}
		administratorRepository.save(administrator);
		return new MessageResponse(true, "success", "update effectuee");
	}

	@Transactional
	@Override
	@Secured("ROLE_ADMIN")

	public MessageResponse delete(Integer id) {
		Administrator administrator = findById(id);
		if (administrator == null) {
			return new MessageResponse(false, "Attention", "utilisateur n'existe pas");
		}

		// userRepository.deleteById(id);
		administratorRepository.delete(administrator);
		return new MessageResponse(true, "success", "delete effectuee");
	}

	@Override
	@Secured("ROLE_ADMIN")

	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}

	@Override
	@Secured("ROLE_ADMIN")

	public Administrator findById(Integer id) {
		return administratorRepository.findById(id).orElse(null);
	}
    @Transactional
	@Override
	@Secured("ROLE_ADMIN")
	public MessageResponse changePassword(PasswordRequest passwordRequest) {
    	Administrator user = administratorRepository.findByUsername(passwordRequest.getUsername());
    	if(user == null) {
			return new MessageResponse(false, "Attention", "utilisateur n'existe pas");
    	}
    	
    	boolean matched = passwordEncoder.matches(passwordRequest.getOldPassword(), user.getPassword());
    	if(!matched) {
			return new MessageResponse(false, "Attention", "password not matched");

    	}
    	
    	
    	String encoderPassword = passwordEncoder.encode(passwordRequest.getNewPassword());
    	user.setPassword(encoderPassword);
    	administratorRepository.save(user);
    	
		return new MessageResponse(true, "success", "update password effectuee");
	}

	
}
