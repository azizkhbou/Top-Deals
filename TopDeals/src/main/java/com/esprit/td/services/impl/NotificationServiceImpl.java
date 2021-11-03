package com.esprit.td.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.td.entities.Deal;
import com.esprit.td.entities.Notification;
import com.esprit.td.repositories.DealRepository;
import com.esprit.td.repositories.NotificationRepository;
import com.esprit.td.services.DealService;
import com.esprit.td.services.NotificationService;

public class NotificationServiceImpl implements NotificationService{
	
	@Autowired
	private NotificationRepository notiRepository;

	@Override
	public List<Notification> retrieveAllNotifications() {
		return (List<Notification>) (notiRepository.findAll());

	}

	@Override
	public Notification addNotification(Notification n) {
		notiRepository.save(n);
		return n;
	}

	@Override
	public void deleteNotification(int idNotification) {
		notiRepository.deleteById(idNotification);		
	}

	@Override
	public Notification updateNotification(Notification n) {
		notiRepository.save(n);
		return n;
	}
	

}
