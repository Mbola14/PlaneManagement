package com.vehicule.flotte_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vehicule.flotte_management.model.Modeles;
import com.vehicule.flotte_management.service.ModelesService;

@RestController
public class ModelesController {

    @Autowired
    ModelesService modelesService;

    @GetMapping("modeles")
    private List<Modeles> getAllModeles() {
        return modelesService.getAllModeles();
    }

    @GetMapping("modeles/{modelesid}")
    private Modeles getModeles(@PathVariable("modeleid") int modelesid) {
        return modelesService.getModelesById(modelesid);
    }

    @DeleteMapping("modeles/{modelesid}")
    private void deleteModele(@PathVariable("modelesid") int modelesid) {
        modelesService.delete(modelesid);
    }

    @PostMapping("modeles")
    private int saveModele(@RequestBody Modeles modeles) {
        modelesService.saveOrUpdate(modeles);
        return modeles.getIdType();
    }

    @PutMapping("modeles")
    private Modeles update(@RequestBody Modeles modeles) {
        modelesService.saveOrUpdate(modeles);
        return modeles;
    }
}
