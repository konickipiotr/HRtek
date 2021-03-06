package com.hrtek.db.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.WorkerDate;

@Repository
public interface WorkerDateRepository extends JpaRepository<WorkerDate, Long> {

}
