package com.hrtek.db.worker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.WorkerBasic;

@Repository
public interface WorkerBasicRepository extends JpaRepository<WorkerBasic, Long> {
	
	List<WorkerBasic> findByDepartment(Long id);
	List<WorkerBasic> findByCitizenship(Integer id);
	
}
