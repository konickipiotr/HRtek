package com.hrtek.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.Factory;

@Repository
public interface FactoryRepository extends JpaRepository<Factory, Long> {

}
