package com.example.accessingdatamysql;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
//public interface UserRepository extends CrudRepository<User, Integer> {

}
