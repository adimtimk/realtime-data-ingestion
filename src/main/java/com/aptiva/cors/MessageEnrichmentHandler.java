package com.aptiva.cors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aptiva.cors.handlers.FileTransactionHanlder;
import com.aptiva.model.Customer;
import com.aptiva.model.FileTransactions;
import com.aptiva.model.GPSData;
import com.aptiva.model.Sales;

import lombok.Builder;
import lombok.extern.log4j.Log4j2;
@Component
@Log4j2

public class MessageEnrichmentHandler extends MessageHandler {
	@Autowired
	private FileTransactionHanlder ftxnHandler;

	@Override
	public void handleNextProcess(String processname, Object message) {
		FileTransactions enrichedObj=null;
		// TODO Auto-generated method stub
		if(message instanceof GPSData) {
			log.info("Start Enrich GPS data {}",((GPSData)message).getGpsTxnID());
			
			 enrichedObj = ftxnHandler.processEnrichment((GPSData)message);
			
			
		}
		if(message instanceof Sales) {
			log.info("Start Enrich Sales data {}",((Sales)message).getSalesDateTxn());
		}
		if(message instanceof Customer) {
			log.info("Start Enrich Customer data {}",((Customer)message).getCustomerId());
		}
		if(!status.equals("FC")){
			next.handleNextProcess(processname, enrichedObj);
		}
	} 

}
