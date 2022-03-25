package com.example.accessingdatamysql;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.List;

//public interface ApiRepository extends JpaRepository<Api, Long> {
public interface ApiRepository extends ReactiveCrudRepository<Api, Long> {
    Flux<Api> findByCode(String code);
}