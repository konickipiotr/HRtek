package com.hrtek.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	boolean existsByDepartment(String department);
}
