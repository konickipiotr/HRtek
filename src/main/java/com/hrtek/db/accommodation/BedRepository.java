package com.hrtek.db.accommodation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.accommodation.Bed;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> {

}
