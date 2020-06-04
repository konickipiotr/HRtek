package com.hrtek.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.Tasks.Task;
import com.hrtek.Tasks.TaskOwner;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	List<Task> findByEmployeeidAndOwnerOrderByDeadlinedate(Long id, TaskOwner owner);
	List<Task> findByOwnerOrderByDeadlinedate(TaskOwner owner);
}
