package com.hrtek.user.worker;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hrtek.db.InUseRepository;
import com.hrtek.model.UserInfo;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class InUseServiceTest {
	
	@Autowired
	private InUseService inUseService;
	@Autowired
	private InUseRepository inUseRepo;
	

	@BeforeEach
	void setUp() throws Exception {
		inUseRepo.deleteAll();
	}

	@Test
	void objectAvailableShouldNeverBeNull() {
		Available av = inUseService.getAvailable(1l);
		assertNotNull(av);
	}
	
	@Test
	void contentOfAvailableCanBeNull() {
		Available av = inUseService.getAvailable(1l);
		
		assertNull(av.getWorker());
		assertNull(av.getBasic());
		assertNull(av.getDate());
		assertNull(av.getResidency());
		assertNull(av.getFinance());
		assertNull(av.getPermit());
		assertNull(av.getStatement());
		assertNull(av.getContact());
		assertNull(av.getAddresspl());
		assertNull(av.getAddress());
	}
	
	@Test
	void workerFieldIsBlocked() {
		Timestamp lt = Timestamp.valueOf(LocalDateTime.now().plusMinutes(5));
		InUse expected = new InUse(1l, 100l, UsedTable.WORKER,lt,"Jan Nowak");
		this.inUseRepo.save(expected);
		
		Available av = inUseService.getAvailable(1l);
		
		
		assertNotNull(av.getWorker());
		assertEquals(expected.getWorkerid(), av.getWorker().getWorkerid());
		assertEquals(expected.getUserid(), av.getWorker().getUserid());
		assertEquals(expected.getUsedTable(), av.getWorker().getUsedTable());
	}
	
	@Test
	void workerThreeFieldsAreBlocked() {
		Timestamp lt = Timestamp.valueOf(LocalDateTime.now().plusMinutes(5));
		InUse expected = new InUse(1l, 100l, UsedTable.WORKER,lt,"Jan Nowak");
		InUse expected1 = new InUse(1l, 100l, UsedTable.BASIC,lt,"Jan Nowak");
		InUse expected2 = new InUse(1l, 100l, UsedTable.ADDRESS,lt,"Jan Nowak");
		InUse expected3 = new InUse(1l, 100l, UsedTable.DATE,lt,"Jan Nowak");
		InUse expected4 = new InUse(1l, 100l, UsedTable.RESIDENCY,lt,"Jan Nowak");
		InUse expected5 = new InUse(1l, 100l, UsedTable.FINANCE,lt,"Jan Nowak");
		InUse expected6 = new InUse(1l, 100l, UsedTable.PERMIT,lt,"Jan Nowak");
		InUse expected7 = new InUse(1l, 100l, UsedTable.STATEMENT,lt,"Jan Nowak");
		InUse expected8 = new InUse(1l, 100l, UsedTable.CONTACT,lt,"Jan Nowak");
		InUse expected9 = new InUse(1l, 100l, UsedTable.ADDRESSPL,lt,"Jan Nowak");

		
		this.inUseRepo.save(expected);
		this.inUseRepo.save(expected1);
		this.inUseRepo.save(expected2);
		this.inUseRepo.save(expected3);
		this.inUseRepo.save(expected4);
		this.inUseRepo.save(expected5);
		this.inUseRepo.save(expected6);
		this.inUseRepo.save(expected7);
		this.inUseRepo.save(expected8);
		this.inUseRepo.save(expected9);
		Available av = inUseService.getAvailable(1l);
		
		assertNotNull(av.getWorker());
		assertEquals(expected.getWorkerid(), av.getWorker().getWorkerid());
		assertEquals(expected.getUserid(), av.getWorker().getUserid());
		assertEquals(expected.getUsedTable(), av.getWorker().getUsedTable());

		assertEquals(expected1.getWorkerid(), av.getBasic().getWorkerid());
		assertEquals(expected1.getUserid(), av.getBasic().getUserid());
		assertEquals(expected1.getUsedTable(), av.getBasic().getUsedTable());


		assertEquals(expected2.getWorkerid(), av.getAddress().getWorkerid());
		assertEquals(expected2.getUserid(), av.getAddress().getUserid());
		assertEquals(expected2.getUsedTable(), av.getAddress().getUsedTable());

		assertEquals(expected3.getWorkerid(), av.getDate().getWorkerid());
		assertEquals(expected3.getUserid(), av.getDate().getUserid());
		assertEquals(expected3.getUsedTable(), av.getDate().getUsedTable());

		assertEquals(expected4.getWorkerid(), av.getResidency().getWorkerid());
		assertEquals(expected4.getUserid(), av.getResidency().getUserid());
		assertEquals(expected4.getUsedTable(), av.getResidency().getUsedTable());
		
		assertNotNull(av.getFinance());
		assertNotNull(av.getPermit());
		assertNotNull(av.getStatement());
		assertNotNull(av.getContact());
		assertNotNull(av.getAddresspl());
	}
	
	@Test
	void ifExpiredUnlock() {
		Timestamp lt = Timestamp.valueOf(LocalDateTime.now().minusSeconds(1));
		InUse expected = new InUse(1l, 100l, UsedTable.PERMIT,lt,"Jan Nowak");
		this.inUseRepo.save(expected);
		
		Available av = inUseService.getAvailable(1l);
		
		assertNull(av.getPermit());
	}
	
	@Test
	void succes_lockup() {
		UserInfo user = new UserInfo(1l, "Adam", "Mucha", "", 2, "", "", 0);
		Long workerid = 100l;
		
		this.inUseService.lockup(user, workerid, UsedTable.CONTACT);
	}

}
