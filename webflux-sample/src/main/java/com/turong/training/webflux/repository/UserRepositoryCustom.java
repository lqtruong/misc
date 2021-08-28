package com.turong.training.webflux.repository;

import com.turong.training.webflux.entity.User;
import reactor.core.publisher.Flux;

public interface UserRepositoryCustom {

    Flux<User>  selectAllUsers();

}
