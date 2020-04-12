package com.entrevista.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrevista.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
}
