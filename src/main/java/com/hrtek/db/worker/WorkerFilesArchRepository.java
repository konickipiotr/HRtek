package com.hrtek.db.worker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.WorkerFilesArch;

@Repository
public interface WorkerFilesArchRepository extends JpaRepository<WorkerFilesArch, Long> {
	List<WorkerFilesArch> findByWorkerid(Long workerid);
	void deleteByWorkerid(Long workerid);
}
