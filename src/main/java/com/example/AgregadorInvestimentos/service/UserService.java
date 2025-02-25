package com.example.AgregadorInvestimentos.service;

import com.example.AgregadorInvestimentos.Controller.CreateUserDTO;
import com.example.AgregadorInvestimentos.Entity.User;
import com.example.AgregadorInvestimentos.UserRepository;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService{

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDTO createUserDTO){

        //DTO -> ENTITY
        var entity = new User(null,
                createUserDTO.username(),
                createUserDTO.Email(),
                createUserDTO.password(),
                Instant.now(),
                null);


        var userSaved = userRepository.save(entity);

        return userSaved.getId();
    }
}
