package me.mikkalmc.login.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.mikkalmc.login.model.ApplicationUser;
import me.mikkalmc.login.repository.ApplicationUserRepository;

@RestController
public class ApplicationUserController {
    @Autowired
    private ApplicationUserRepository userRepository;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationUserController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/user")
    public List<ApplicationUser> index() {
        return userRepository.findAll();
    }

    @PostMapping(path = "/registration", consumes = "application/json", produces = "application/json")
    public ApplicationUser createUser(@RequestBody Map<String, String> body){
        System.out.println(body);
        String username = body.get("username");
        String password = body.get("password");
        ApplicationUser newUser = new ApplicationUser(username, password);
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        return this.userRepository.save(newUser);
    }
}