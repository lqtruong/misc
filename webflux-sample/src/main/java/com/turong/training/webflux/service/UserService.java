package com.turong.training.webflux.service;

import com.turong.training.webflux.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> getUser(String id);

    Mono<User> create(User userToCreate);

    Mono<Void> deleteByEmail(String email);

    Mono<Void> deleteById(String id);

    Flux<User> getAll();

}
