package com.vehicule.flotte_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.vehicule.flotte_management.model.User;
import com.vehicule.flotte_management.repository.UsersRepository;
import com.vehicule.flotte_management.exceptions.AuthenticationException;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public User authenticate(User auth) throws AuthenticationException {
        User curr_user = usersRepository.findUserByEmailAndAndPassword(auth.getUsername(), DigestUtils.md5DigestAsHex(auth.getPassword().getBytes()));
        if(curr_user == null) {
            throw new AuthenticationException("username or password incorrect");
        }

        return curr_user;
    }
}