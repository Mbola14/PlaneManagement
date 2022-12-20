package com.vehicule.flotte_management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.flotte_management.model.Compagnie;

@Repository
public interface CompagnieRepository extends CrudRepository<Compagnie,Integer> {
}
