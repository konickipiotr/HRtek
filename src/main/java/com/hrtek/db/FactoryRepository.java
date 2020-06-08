package com.hrtek.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.Factory;
import com.hrtek.model.StatusFC;

import ch.qos.logback.core.status.Status;

@Repository
public interface FactoryRepository extends JpaRepository<Factory, Long> {

	boolean existsByNip(String nip);
	boolean existsByKrs(String krs);
	boolean existsByShortname(String shortname);
	boolean existsByFullname(String fulname);
	List<Factory> findByStatus(StatusFC status);
}
