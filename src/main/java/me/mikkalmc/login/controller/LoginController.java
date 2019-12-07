package me.mikkalmc.login.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.mikkalmc.login.model.User;
import me.mikkalmc.login.service.UserService;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public String login(@RequestBody Map<String, String> body) {
        // String reqPassword = body.get("password");
        String reqEmail = body.get("email");

        User user = userService.findUserByEmail(reqEmail);
        String test = user.toString();
        return test;
    }
}