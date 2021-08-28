package com.turong.training.rest.service;

import com.turong.training.rest.entity.User;

import java.util.List;

public interface UserService {

    User getUser(String id);

    User create(User userToCreate);

    int deleteByEmail(String email);

    int deleteById(String id);

    List<User> getAll();

}
