package com.example.accessingdatamysql;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

//public interface MemberRepository extends JpaRepository<Member, Integer>{}
public interface MemberRepository extends ReactiveCrudRepository<Member, Integer> {

    Flux<Member> findByName(String name);

}