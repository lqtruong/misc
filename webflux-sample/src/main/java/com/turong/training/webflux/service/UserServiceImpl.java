package com.turong.training.webflux.service;

import com.turong.training.webflux.entity.User;
import com.turong.training.webflux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<User> getUser(String id) {
        return userRepository.findById(Long.valueOf(id));
    }

    @Override
    public Mono<User> create(User userToCreate) {
        return userRepository.save(userToCreate);
    }

    @Override
    public Mono<Void> deleteByEmail(String email) {
        return userRepository.deleteByEmail(email);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return userRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public Flux<User> getAll() {
        return userRepository.selectAllUsers(); // findAll();
    }

}
