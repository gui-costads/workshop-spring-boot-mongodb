package com.springmongodb.workshopmongodb.services;

import com.springmongodb.workshopmongodb.domain.User;
import com.springmongodb.workshopmongodb.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        List<User> userList = userRepository.findAll();
        return userList;
    }
}
