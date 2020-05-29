package com.hrtek.db.accommodation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.accommodation.Bed;
import com.hrtek.user.accommodation.Bedstatus;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> {
	
	List<Bed> findByBedstatus(Bedstatus bedstatus);
	List<Bed> findByBedstatusAndHouseid(Bedstatus bedstatus, Long houseid);

}
