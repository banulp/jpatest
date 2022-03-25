package com.example.accessingdatamysql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {}