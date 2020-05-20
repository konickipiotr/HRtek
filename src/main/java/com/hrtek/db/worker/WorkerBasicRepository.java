package com.hrtek.db.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.WorkerBasic;

@Repository
public interface WorkerBasicRepository extends JpaRepository<WorkerBasic, Long> {

}
