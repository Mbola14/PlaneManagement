package com.vehicule.flotte_management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.flotte_management.model.CompagnieAssurance;

@Repository
public interface CompagnieAssuranceRepository extends CrudRepository<CompagnieAssurance,Integer> {
}
