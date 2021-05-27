package com.hrtek.db.worker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
	List<Worker> findByCompanyid(Long id);
	List<Worker> findByRecruiter(Long id);
	List<Worker> findByCompanyidAndFactoryid(Long companyid, Long factoryid);
	List<Worker> findByFactoryid(Long factoryid);
	List<Worker> findByCompanyidAndFactoryidOrderByLastnameAsc(Long companyid, Long factoryid);
	int countByCompanyidAndFactoryid(Long companyid, Long factoryid);
	
	int countByFactoryid(Long factoryid);
	int countByCompanyid(Long factoryid);
}
