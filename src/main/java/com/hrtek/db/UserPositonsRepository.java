package com.hrtek.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.UserPostions;

@Repository
public interface UserPositonsRepository extends JpaRepository<UserPostions, Integer> {

}
