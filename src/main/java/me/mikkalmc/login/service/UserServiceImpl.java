package me.mikkalmc.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import me.mikkalmc.login.model.ApplicationUser;
import me.mikkalmc.login.repository.ApplicationUserRepository;

import java.util.Arrays;
import java.util.HashSet;

import static java.util.Collections.emptyList;

@Service("userService")
public class UserServiceImpl implements UserDetailsService{
    private ApplicationUserRepository userRepository;

    @Autowired
    public UserServiceImpl(ApplicationUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(), user.getPassword(), emptyList());
    }
}