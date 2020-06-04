package com.hrtek.db.worker;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.WorkerBasic;

@Repository
public interface WorkerBasicRepository extends JpaRepository<WorkerBasic, Long> {
	
}
