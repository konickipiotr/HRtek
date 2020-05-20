package com.hrtek.db.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.WorkerFinance;

@Repository
public interface WorkerFinanceRepository extends JpaRepository<WorkerFinance, Long> {

}
