package com.hrtek.db.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.PermitStatement;

@Repository
public interface WorkerPermintRepository extends JpaRepository<PermitStatement, Long> {

}
