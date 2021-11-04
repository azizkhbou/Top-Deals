package com.esprit.td.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.td.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
