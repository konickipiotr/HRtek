package com.hrtek.db.accommodation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.accommodation.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
	List<Room> findByHouseid(Long houseid);

}
