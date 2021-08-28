package com.turong.training.webflux.repository;

import com.turong.training.webflux.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long>, UserRepositoryCustom {

    Mono<Void> deleteByEmail(String email);
    
}
