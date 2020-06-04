package com.hrtek.db.worker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.user.timesheet.Timesheet;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

		List<Timesheet> findByFactoryid(Long id);
}
