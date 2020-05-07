package com.hrtek.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.Citizenship;

@Repository
public interface CitizenshipRepository extends JpaRepository<Citizenship, Integer> {
	boolean existsByName(String citizenship);
}
