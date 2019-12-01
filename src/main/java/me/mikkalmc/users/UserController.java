package me.mikkalmc.users;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public List<User> index() {
        return userRepository.findAll();
    }

    @PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public User create(@RequestBody Map<String, String> body){
        System.out.println(body);
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        String password = body.get("password");

        return userRepository.save(new User(firstName, lastName, password));
    }
}