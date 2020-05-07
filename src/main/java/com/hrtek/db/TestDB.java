package com.hrtek.db;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.model.Factory;

@Service
public class TestDB {
	
	private FactoryRepository factoryRepo;

	@Autowired
	public TestDB(FactoryRepository factoryRepo) {
		this.factoryRepo = factoryRepo;
	}
	
	public void fill() {
		this.factoryRepo.deleteAll();
		
		Factory f1 = new Factory("45686", "1597534589", "1165159554", "DongYang", "Dong Yang internatinal sp z o.o.", "Jan 43", "42-548", "Wrocław", 0, 17.25);
		Factory f2 = new Factory("14326", "1516551129", "4587466611", "Fabryk 2", "zong Yang internatinal sp z o.o.", "Mickiewicza 43", "42-548", "Krocław", 0, 17.25);
		Factory f3 = new Factory("31586", "1596556689", "1551651854", "Fabryka 3", "bong Yang internatinal sp z o.o.", "Adama 342", "32-548", "Brocław", 0, 17.25);
		Factory f4 = new Factory("13586", "1561834589", "2987435774", "Fabryka 4", "tong Yang internatinal sp z o.o.", "Kochanowskiego 34", "14-448", "Orocław", 0, 17.25);
		this.factoryRepo.saveAll(Arrays.asList(f1,f2,f3,f4));
		
	}
	
	

}
