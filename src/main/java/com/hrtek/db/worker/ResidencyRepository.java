package com.hrtek.db.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.Residency;

@Repository
public interface ResidencyRepository extends JpaRepository<Residency, Long> {

}
