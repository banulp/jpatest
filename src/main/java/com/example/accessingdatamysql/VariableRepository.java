package com.example.accessingdatamysql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VariableRepository extends JpaRepository<Variable, Long> {

}