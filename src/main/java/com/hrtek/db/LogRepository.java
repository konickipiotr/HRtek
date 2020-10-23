package com.hrtek.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hrtek.model.Log;


@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
	
	@Query(value = "from Log Order by tstamp")
	List<Log> zz();
	
	List<Log> findAllByOrderByTstampDesc();

}
