package com.hrtek.db.accommodation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.accommodation.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

}
