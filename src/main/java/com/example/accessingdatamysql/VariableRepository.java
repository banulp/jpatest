package com.example.accessingdatamysql;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

//public interface VariableRepository extends JpaRepository<Variable, Long> {
public interface VariableRepository extends ReactiveCrudRepository<Variable, Long> {

}