package com.hrtek.db.worker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.Contact;

@Repository
public interface WorkerContactRepository extends JpaRepository<Contact, Long> {
	
	@Query(value = "From Contact c where c.bedid=NULL")
	List<Contact> withoutBed();

}
