package com.vehicule.flotte_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vehicule.flotte_management.model.Avion;
import com.vehicule.flotte_management.service.AvionService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:1602")
public class AvionController {
    @Autowired
    AvionService avionService;

    @GetMapping("avions")
    private List<Avion> getAllPlane() {
        return avionService.getAllPlane();
    }

    @GetMapping("avions/{idavion}")
    private Avion getAllKilometrages(@PathVariable("idavion") int idavion) {
        return avionService.getPlaneById(idavion);
    }

    @DeleteMapping("avions/{idavion}")
    private void deleteBook(@PathVariable("idavion") int idavion) {
        avionService.delete(idavion);
    }

    @PostMapping("avions")
    private int saveBook(@RequestBody Avion avion) {
        avionService.saveOrUpdate(avion);
        return avion.getidAvion();
    }

    @PutMapping("avions")
    private Avion update(@RequestBody Avion avion) {
        avionService.saveOrUpdate(avion);
        return avion;
    }
}
