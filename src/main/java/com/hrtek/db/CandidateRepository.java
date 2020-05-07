package com.hrtek.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.user.recruitment.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
