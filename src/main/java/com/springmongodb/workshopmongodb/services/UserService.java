package com.springmongodb.workshopmongodb.services;

import com.springmongodb.workshopmongodb.domain.User;
import com.springmongodb.workshopmongodb.dto.UserDTO;
import com.springmongodb.workshopmongodb.repositories.UserRepository;
import com.springmongodb.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public User findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public User createUser(User user){
        return userRepository.insert(user);
    }

    public User updateUser(User user){
        User userToUpdate = findById(user.getId());
        updateData(userToUpdate, user);
        return userRepository.save(userToUpdate);
    }

    private void updateData(User userToUpdate, User user) {
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);

    }

}
