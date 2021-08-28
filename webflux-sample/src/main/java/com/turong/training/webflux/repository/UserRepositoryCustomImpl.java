package com.turong.training.webflux.repository;

import com.turong.training.webflux.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import reactor.core.publisher.Flux;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @Autowired
    private R2dbcEntityTemplate template;

    @Override
    public Flux<User> selectAllUsers() {
        return template.select(User.class).all();
    }

}
