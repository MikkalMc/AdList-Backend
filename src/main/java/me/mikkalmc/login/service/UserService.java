package me.mikkalmc.login.service;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import me.mikkalmc.login.model.Role;
import me.mikkalmc.login.model.User;
import me.mikkalmc.login.repository.RoleRepository;
import me.mikkalmc.login.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;


@Service("userService")
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        user.setPassword(user.getPassword());
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
        return user;
    }
}