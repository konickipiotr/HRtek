package com.hrtek.admin.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.db.FactoryRepository;

@Service
public class FactoryService {
	
	@Autowired
	public FactoryRepository factoryRepo;
	
	 
}
