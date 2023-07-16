package com.managecorp.fastmanagementapi.services;

import com.managecorp.fastmanagementapi.exceptions.NotFoundException;
import com.managecorp.fastmanagementapi.exceptions.UnauthorizedException;
import com.managecorp.fastmanagementapi.models.User;
import com.managecorp.fastmanagementapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    AuthHelper auth;

    public List<User> sendUsers() {
        List<User> users = (List) repository.findAll();
        return  users;
    }

    public String login (User user) throws Exception {
        User dbUser = repository.findByEmail(user.getEmail()).orElseThrow(() -> {
            throw new NotFoundException("No user for giver email");
        });

        boolean isAuthenticated = auth.verifyPassword(user.getPassword(), dbUser.getPassword());

        if(!isAuthenticated) throw new UnauthorizedException("Senha e email não conferem");

        String token = auth.createToken(user.getId());
        return token;
    }

    public User createUser (User user) throws Exception {
        user.setPassword(auth.encryptPassword(user.getPassword()));
        User newUser = repository.save(user);
        return newUser;
    }

}
