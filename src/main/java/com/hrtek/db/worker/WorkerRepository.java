package com.hrtek.db.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
