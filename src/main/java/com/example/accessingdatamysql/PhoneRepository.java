package com.example.accessingdatamysql;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.Set;

//public interface PhoneRepository extends JpaRepository<Phone, Integer> {}
public interface PhoneRepository extends ReactiveCrudRepository<Phone, Integer> {

    @Query("select phone.* from phone where member_id in (:memberIds)")
    Flux<Phone> findAllWithMembers(Set<Long> memberIds);

}