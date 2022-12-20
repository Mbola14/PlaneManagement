package com.vehicule.flotte_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vehicule.flotte_management.model.Image;
import com.vehicule.flotte_management.service.ImgService;

@RestController
@CrossOrigin("http://localhost:1602")
public class ImgController {
    @Autowired
    ImgService imgService;
    
    @PostMapping("saveImg")
    public Image save(@RequestBody Image image) {
        return imgService.saveImg(image);
    }

    @PutMapping("updateImg")
    public Image update(@RequestBody Image image) {
        return imgService.updateImg(image);
    }
}
