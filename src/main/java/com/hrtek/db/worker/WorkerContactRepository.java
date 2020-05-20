package com.hrtek.db.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.worker.Contact;

@Repository
public interface WorkerContactRepository extends JpaRepository<Contact, Long> {

}
