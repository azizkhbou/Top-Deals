package com.esprit.td.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.td.entities.Review;


@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer>{

}
