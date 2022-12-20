package com.vehicule.flotte_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.flotte_management.model.Image;
import com.vehicule.flotte_management.repository.ImgRepository;

@Service
public class ImgService {
    @Autowired
    ImgRepository imgRepository;
    
    public Image saveImg(Image img) {
        return imgRepository.save(img);
    }

    public Image updateImg(Image img) {
        return imgRepository.save(img);
    }
}
