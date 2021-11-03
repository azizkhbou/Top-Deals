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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.td.entities.Deal;
import com.esprit.td.entities.Notification;
import com.esprit.td.requests.PasswordRequest;
import com.esprit.td.responses.MessageResponse;
import com.esprit.td.services.DealService;
import com.esprit.td.services.MapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/deal")

public class DealController {
	
	@Autowired
	 DealService dealService;
	
	@GetMapping("/retrieve-all-deals")
	public List<Deal> getDeals(){
		List<Deal> list = dealService.retrieveAllDeals();
		return list;	}

	@PostMapping("/add-deal")
	@ResponseBody
	public Deal addDeal(@RequestBody Deal d) {
		Deal deal = dealService.addDeal(d);
		return deal;
	}
	
	@DeleteMapping("/remove-deal/{deal-id}")
    @ResponseBody
	public void removedeal(@PathVariable("deal-id") int idDeal) {
		dealService.deleteDeal(idDeal);
	}
	
	@PutMapping("/modify-deal")
    @ResponseBody
	public Deal modifyUser(@RequestBody Deal d) {
	return dealService.updateDeal(d);
	}
	

}
