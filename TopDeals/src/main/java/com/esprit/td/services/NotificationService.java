package com.esprit.td.services;

import java.util.List;

import com.esprit.td.entities.Deal;
import com.esprit.td.entities.Notification;

public interface NotificationService {
	
	List<Notification> retrieveAllNotifications();
	Notification addNotification(Notification n);
	void deleteNotification(int idNotification);
	Notification updateNotification(Notification n);

}
