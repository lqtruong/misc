package com.turong.training.webflux.controller;

import com.turong.training.webflux.convert.UserConvert;
import com.turong.training.webflux.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserConvert userConvert;

    @GetMapping("/{id}")
    public Mono<UserResponse> getUser(@PathVariable final String id) {
        log.debug("Get user with id={}", id);
        return userService.getUser(id).map(userConvert::toResponse);
    }

    @PostMapping
    public Mono<UserResponse> createUser(@RequestBody final UserSaveRequest userSaveRequest) {
        userValidator.validate(userSaveRequest);
        return userService.create(userConvert.toUser(userSaveRequest)).map(userConvert::toResponse);
    }

    @DeleteMapping
    public Mono<Void> deleteUserByEmail(@RequestParam final String email) {
        log.info("Delete user with email={}", email);
        if (StringUtils.isBlank(email)) {
            throw new IllegalArgumentException("Email to delete must be present!");
        }
        return userService.deleteByEmail(email);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUserById(@PathVariable final String id) {
        if (StringUtils.isBlank(id)) {
            throw new IllegalArgumentException("Id to delete must be present!");
        }
        return userService.deleteById(id);
    }

    @GetMapping("/all")
    public Flux<UserResponse> getAllUsers() {
        log.debug("Get all users");
        return userService.getAll().map(userConvert::toResponse);
    }

}