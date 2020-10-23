package com.hrtek.db.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.user.dismissed.Dismissed;

@Repository
public interface DismissRepository extends JpaRepository<Dismissed, Long> {

}
