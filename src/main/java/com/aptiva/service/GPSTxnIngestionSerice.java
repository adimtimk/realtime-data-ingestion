package com.aptiva.service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aptiva.model.GPSData;
import com.aptiva.repo.GPSRepo;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class GPSTxnIngestionSerice {
	@Autowired
	private GPSRepo grepo;
	final AtomicInteger gpstxnid = new AtomicInteger(0);
	public void savetoDBGPSTXN(GPSData gps) {
		 Random random = new Random();
//		 UUID uuid = new UUID(Uuids.startOf(Timestamp.valueOf(LocalDateTime.now()).getTime()).getMostSignificantBits(), random.nextLong());
		
		gps.setGpsTxnID(random.nextInt(100,10000 ));
		log.info("Saving.random gps id.. for {}",gps.getGpsTxnID());
		GPSData saved = grepo.save(gps);
		log.info("Saved..{}", saved);

	}
}
