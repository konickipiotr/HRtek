package com.hrtek.db.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.WorkerFiles;

@Repository
public interface WorkerFilesRepository extends JpaRepository<WorkerFiles, Long> {

}
