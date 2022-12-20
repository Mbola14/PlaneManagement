package com.vehicule.flotte_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vehicule.flotte_management.model.Kilometrages;
import com.vehicule.flotte_management.service.KilometragesService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:1602")
public class KilometragesController {
    @Autowired
    KilometragesService kilometragesService;

    @GetMapping("kilometrages/avions/{planeId}")
    private List<Kilometrages> getKilometragesByPlaneId(@PathVariable("planeId") int planeId) {
        return kilometragesService.gKilometragesByPlaneId(planeId);
    }

    @GetMapping("kilometrages")
    private List<Kilometrages> getAllKilometrages() {
        return kilometragesService.getAllKilometrages();
    }

    @GetMapping("kilometrages/{idkm}")
    private Kilometrages getAllKilometrages(@PathVariable("idkm") int idKm) {
        return kilometragesService.getKilometragesById(idKm);
    }

    @DeleteMapping("kilometrages/{idkm}")
    private void deleteBook(@PathVariable("idkm") int idKm) {
        kilometragesService.delete(idKm);
    }

    @PostMapping("kilometrages")
    private int saveBook(@RequestBody Kilometrages kms) {
        kilometragesService.saveOrUpdate(kms);
        return kms.getId();
    }

    @PutMapping("kilometrages")
    private Kilometrages update(@RequestBody Kilometrages kms) {
        kilometragesService.saveOrUpdate(kms);
        return kms;
    }
}