package com.hrtek.db;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.user.worker.InUse;
import com.hrtek.user.worker.UsedTable;

@Repository
public interface InUseRepository extends JpaRepository<InUse, Long> {

	List<InUse> findByWorkerid(Long id);
	void deleteByExpiredBefore(LocalDateTime newTime);
	void deleteByWorkeridAndUsedTableAndUserid(Long id, UsedTable ut, Long userid);
	
	InUse findByWorkeridAndUsedTable(Long id, UsedTable ut);
	
	boolean existsByWorkeridAndUsedTable(Long id, UsedTable ut);
}
