package com.vehicule.flotte_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehicule.flotte_management.model.Kilometrages;

@Repository
public interface KilometragesRepository extends CrudRepository<Kilometrages,Integer> {
    @Query(value = "select * from kilometrages where idavion= :planeid", nativeQuery = true)
    public List<Kilometrages> getKilometragesByPlane(@Param("planeid") int planeid);
}