package me.mikkalmc.login.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.mikkalmc.login.model.User;
import me.mikkalmc.login.repository.UserRepository;
import me.mikkalmc.login.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> index() {
        return userRepository.findAll();
    }

    @PostMapping(path = "/registration", consumes = "application/json", produces = "application/json")
    public User createUser(@RequestBody Map<String, String> body){
        System.out.println(body);
        String email = body.get("email");
        String password = body.get("password");
        User newUser = new User(email, password);

        return this.userService.saveUser(newUser);
    }
}