package com.example.accessingdatamysql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<Api, Long> {
}