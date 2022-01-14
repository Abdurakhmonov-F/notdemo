package com.example.notdemo.controller;

import com.example.notdemo.domain.UserEntity;
import com.example.notdemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/user/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ResponseStatus(CREATED)
    @PostMapping(path = "/signup", consumes = APPLICATION_JSON_VALUE)
    public Mono<UserEntity> signup(@RequestBody UserEntity user){
        return userService.signup(user);
    }
}
