package com.vehicule.flotte_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.flotte_management.model.Avion;
import com.vehicule.flotte_management.repository.AvionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvionService {
    @Autowired
    AvionRepository avionRepository;

    public List<Avion> getAllPlane() {
        List<Avion> avions = new ArrayList<>();
        avionRepository.findAll().forEach(books1 -> avions.add(books1));
        return avions;
    }

    public Avion getPlaneById(int id) {
        return avionRepository.findById(id).get();
    }

    public void saveOrUpdate(Avion avion) {
        avionRepository.save(avion);
    }

    public void delete(int id) {
        avionRepository.deleteById(id);
    }

    public void update(Avion avion, int bookid) {
        avionRepository.save(avion);
    }
}
