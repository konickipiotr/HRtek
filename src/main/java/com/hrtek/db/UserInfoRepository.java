package com.hrtek.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hrtek.model.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
	boolean existsByFirstnameAndLastname(String firstname, String lastname);
	
	@Query(value = "from UserInfo where position=:agent or position=:coordinator")
	List<UserInfo> getAgentsAndCoordinators(@Param("agent") int agent, @Param("coordinator") int coordinators);
	
	List<UserInfo> findByPosition(int pos);
}
