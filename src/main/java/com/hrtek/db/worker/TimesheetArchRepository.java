package com.hrtek.db.worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.user.timesheet.TimesheetArch;

@Repository
public interface TimesheetArchRepository extends JpaRepository<TimesheetArch, Long>{

}
