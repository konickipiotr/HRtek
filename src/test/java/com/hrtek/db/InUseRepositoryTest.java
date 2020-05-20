package com.hrtek.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.hrtek.user.worker.InUse;
import com.hrtek.user.worker.UsedTable;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Transactional
class InUseRepositoryTest {

	@Autowired
	private InUseRepository inUserRepo;
	
	@BeforeEach
	void setUp() throws Exception {
		inUserRepo.deleteAll();
	}

	@Test
	void test_empty_db() {
		List<InUse> actual = inUserRepo.findByWorkerid(1l); 
		
		assertEquals(0, actual.size());
	}
	
	@Test
	void not_delete_if_current_date_is_before() {
		Timestamp lt = Timestamp.valueOf(LocalDateTime.now().plusMinutes(5));
		
		this.inUserRepo.save(new InUse(1l, 100l, UsedTable.WORKER,lt,"Jan Nowak"));
		this.inUserRepo.deleteByExpiredBefore(Timestamp.valueOf(LocalDateTime.now()));
		
		List<InUse> current = this.inUserRepo.findAll();
		assertEquals(1, current.size());
	}
	
	@Test
	void table_is_empty_when_record_is_expired() {
		Timestamp lt = Timestamp.valueOf(LocalDateTime.now().minusMinutes(1));
		
		this.inUserRepo.save(new InUse(1l, 100l, UsedTable.WORKER,lt,"Jan Nowak"));
		this.inUserRepo.deleteByExpiredBefore(Timestamp.valueOf(LocalDateTime.now()));
		
		List<InUse> current = this.inUserRepo.findAll();
		assertEquals(0, current.size());
	}
	
	@Test
	void more_test() {
		
		this.inUserRepo.save(new InUse(1l, 100l, UsedTable.WORKER,Timestamp.valueOf(LocalDateTime.now().minusMinutes(1)),"Jan Nowak"));
		this.inUserRepo.save(new InUse(1l, 100l, UsedTable.WORKER,Timestamp.valueOf(LocalDateTime.now().plusMinutes(1)),"Jan Nowak"));
		this.inUserRepo.save(new InUse(1l, 100l, UsedTable.WORKER,Timestamp.valueOf(LocalDateTime.now().plusMinutes(3)),"Jan Nowak"));
		this.inUserRepo.save(new InUse(1l, 100l, UsedTable.WORKER,Timestamp.valueOf(LocalDateTime.now().minusSeconds(1)),"Jan Nowak"));
		this.inUserRepo.save(new InUse(1l, 100l, UsedTable.WORKER,Timestamp.valueOf(LocalDateTime.now().minusMinutes(2)),"Jan Nowak"));
		
		List<InUse> old = this.inUserRepo.findAll();
		this.inUserRepo.deleteByExpiredBefore(Timestamp.valueOf(LocalDateTime.now()));
		List<InUse> current = this.inUserRepo.findAll();
		
		assertEquals(5, old.size());
		assertEquals(2, current.size());
	}
	
	@Test
	void getSingleInUseObject() {
		this.inUserRepo.save(new InUse(1l, 100l, UsedTable.BASIC,Timestamp.valueOf(LocalDateTime.now().plusMinutes(1)),"Jan Nowak"));
		
		InUse current = this.inUserRepo.findByWorkeridAndUsedTable(1l, UsedTable.BASIC);
		
		assertNotNull(current);
		assertEquals(1l, current.getWorkerid());
		assertEquals(100l, current.getUserid());
	}
	
	@Test
	void ifRecordDoesNotExistReturnNull() {
		InUse current = this.inUserRepo.findByWorkeridAndUsedTable(1l, UsedTable.BASIC);
		
		assertNull(current);
	}
	
	@Test
	void test_existsByStatement() {
		
		Long id = 1l;
		UsedTable usedTable = UsedTable.BASIC;
		
		this.inUserRepo.save(new InUse(id, 100l, usedTable,Timestamp.valueOf(LocalDateTime.now().plusMinutes(2)),"Jan Nowak"));
		
		assertTrue(this.inUserRepo.existsByWorkeridAndUsedTable(id, usedTable));
		assertFalse(this.inUserRepo.existsByWorkeridAndUsedTable(2l, usedTable));
	}
}
