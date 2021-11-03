package com.esprit.td.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.td.entities.User;
import com.esprit.td.requests.PasswordRequest;
import com.esprit.td.responses.MessageResponse;
import com.esprit.td.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
@Api(description = "api al class")
public class UserController {
	@Autowired
	private UserService userService;
	// matnajamech ykoun andi 2 methode b fard url 
	@ApiOperation ("api al methode")
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
	}


	@PostMapping
	public MessageResponse save (@RequestBody @ApiParam("api al parammetre ") User user) {
		return userService.save(user);
		
	}
	@PutMapping
	public MessageResponse update(@RequestBody User user) {
		return userService.update(user);
		
	}
	//@PatchMapping kif tabda bech tbadel hajja bark 
	@PatchMapping
	public MessageResponse changePassword(@RequestBody PasswordRequest passwordRequest) {
		return userService.changePassword(passwordRequest);
		
	}
	@GetMapping("/{id}")
	public User findById(@PathVariable Integer id){
		return userService.findById(id);
	}

@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable Integer id){
		return userService.delete(id);
	}

}
