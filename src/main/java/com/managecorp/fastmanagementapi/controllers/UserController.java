package com.managecorp.fastmanagementapi.controllers;

import com.managecorp.fastmanagementapi.dtos.TokenDto;
import com.managecorp.fastmanagementapi.models.User;
import com.managecorp.fastmanagementapi.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("")
    public ResponseEntity postUser (@Valid @RequestBody User user) throws Exception {
        User newUser = service.createUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<TokenDto> postLogin (@Valid @RequestBody User user) throws Exception {
        String token = service.login(user);
        return new ResponseEntity(new TokenDto(token), HttpStatus.CREATED);
    }
}
