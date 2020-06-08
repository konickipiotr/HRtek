package com.hrtek.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.Company;
import com.hrtek.model.StatusFC;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	boolean existsByNip(String nip);
	boolean existsByKrs(String krs);
	boolean existsByShortname(String shortname);
	boolean existsByFullname(String fulname);
	boolean existsByKraz(String kraz);
	boolean existsByRegon(String regon);
	List<Company> findByStatus(StatusFC status);
}
