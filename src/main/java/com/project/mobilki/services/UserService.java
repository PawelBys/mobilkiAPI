package com.project.mobilki.services;

import com.project.mobilki.entity.Product;
import com.project.mobilki.entity.User;
import com.project.mobilki.repository.ProductRepository;
import com.project.mobilki.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUser(int id){
        return userRepository.findById(id);
    }

    public User searchUser(String email, String password){
        return userRepository.searchFor(email, password);
    }

    public User searchUserId(int id){
        return userRepository.searchForId(id);
    }

    public void deleteUserWithId(int id){
        userRepository.deleteId(id);
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
