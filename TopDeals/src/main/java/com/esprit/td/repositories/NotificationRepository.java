package com.esprit.td.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.td.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>  {
	

}
