package com.hrtek.db.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.WorkerNote;

@Repository
public interface WorkerNoteRepository extends JpaRepository<WorkerNote, Long> {

}
