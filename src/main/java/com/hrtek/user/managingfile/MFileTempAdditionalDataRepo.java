package com.hrtek.user.managingfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MFileTempAdditionalDataRepo extends JpaRepository<MFileTempAdditionalData, Long> {

    List<MFileTempAdditionalData> findByYearAndMonth(int year, int month);
    Optional<MFileTempAdditionalData> findByYearAndMonthAndWorkerid(int year, int month, Long workerid);
}
