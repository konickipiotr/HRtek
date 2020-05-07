package com.hrtek.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.Factory;

@Repository
public interface FactoryRepository extends JpaRepository<Factory, Long> {

	boolean existsByNip(String nip);
	boolean existsByKrs(String krs);
	boolean existsByShortname(String shortname);
	boolean existsByFullname(String fulname);
}
