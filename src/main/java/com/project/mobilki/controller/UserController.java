package com.project.mobilki.controller;


import com.project.mobilki.entity.Product;
import com.project.mobilki.entity.User;
import com.project.mobilki.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost/", allowedHeaders = "*", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allusers")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @PostMapping("/addusers")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Optional<User> getUser(@RequestParam int id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<User> searchUser(@RequestParam String email, String password){
        return userService.searchProduct(email, password);
    }

    @RequestMapping(value = "/searchid", method = RequestMethod.GET)
    public User searchUser(@RequestParam int id){
        return userService.searchUserId(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteUserWithId(@RequestParam int id){
        userService.deleteUserWithId(id);
    }

    @RequestMapping(value = "/killall", method = RequestMethod.DELETE)
    public void deleteAllUsers(){userService.deleteAllUsers();}
}
