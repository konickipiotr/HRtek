package com.hrtek.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
