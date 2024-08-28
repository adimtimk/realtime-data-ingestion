package com.aptiva.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptiva.model.Sales;
import com.aptiva.repo.SalesRepo;

import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
public class SalesTxnIngestionService {
	@Autowired
	private SalesRepo srepo;
	final AtomicInteger salestxnid = new AtomicInteger(0);
	public void savetoSalesTXN(Sales sales) {
		String formats = "yyyy-MM-dd HH:mm:ss";
		Random rand = new Random();
		;
		log.info("Saving...");
//		sales.setSalesId(rand.nextInt(10000));
	    String date = new SimpleDateFormat(formats, new Locale("en", "IN")).format(sales.getSalesDateTxn()); // 2021-11-05 10:03:58
	    log.info("Start Ingesting Sales date {}",date);
	    try {
			log.info("format Ingesting Sales date {}",new SimpleDateFormat(formats).parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sales.setSalesDateTxn(new java.sql.Timestamp(new SimpleDateFormat(formats).parse(date).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sales.setSalesId(salestxnid.incrementAndGet());
		Sales saved = srepo.save(sales);
		log.info("Saved...");
		
	}
}
