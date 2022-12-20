package com.vehicule.flotte_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.flotte_management.model.Key;
import com.vehicule.flotte_management.repository.KeyRepository;

@Service
public class KeyService {
    @Autowired
	KeyRepository keyRepository;

    public Key fetchKey() {
        return keyRepository.findById(1).get();
    }
}
