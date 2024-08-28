package com.aptiva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptiva.model.Customer;
import com.aptiva.model.GPSData;
import com.aptiva.repo.CustomerRepo;

import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
public class CustomerTxnIngestionService {
	@Autowired
	private CustomerRepo crepo;
	
	public void savetoDBCustTXN(Customer cust) {
		log.info("Saving...");
		Customer saved = crepo.save(cust);
		log.info("Saved...");
		
	}
	
	
}
