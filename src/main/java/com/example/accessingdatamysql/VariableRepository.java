package com.example.accessingdatamysql;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.Set;

//public interface VariableRepository extends JpaRepository<Variable, Long> {
public interface VariableRepository extends ReactiveCrudRepository<Variable, Long> {

    @Query("select variable.* from variable where api_id in (:apiIds)")
    Flux<Variable> findAllWithApis(Set<Long> apiIds);

}