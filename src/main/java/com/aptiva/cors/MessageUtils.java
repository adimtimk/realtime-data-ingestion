package com.aptiva.cors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aptiva.model.Customer;
import com.aptiva.model.GPSData;
import com.aptiva.model.GPSDataMessage;
import com.aptiva.model.Sales;
@Component
public class MessageUtils {
	@Autowired
	private MessageValidationHandler mv;
	@Autowired
	private MessageIngestionHandler mInges;
	
	@Autowired
	private MessageHashingHandler mHash;
	@Autowired
	private MessageFiltrationAndTxnIngestionHandler mFiltxn;
	@Autowired
	private MessageFileCreationHandler mFileCreate;
	@Autowired
	private MessageEnrichmentHandler mEnrich;
	
	public void processGPSSteps(GPSData gps) {
		 mv.setStatus("MV");
		 mv.setNext(mInges);
		 mInges.setStatus("Inges");
		 mInges.setNext(mEnrich);
		 mEnrich.setStatus("Enrich");
		 mEnrich.setNext(mHash);
		 mHash.setStatus("Hash");
		 mHash.setNext(mFiltxn);
		 mFiltxn.setStatus("FC");
		 mFiltxn.setNext(mFileCreate);
		 mv.handleNextProcess("GPS & File Handler called -", gps);
		 
	}

	public void processCustomerSteps(Customer cust) {
		// TODO Auto-generated method stub
		 mv.setStatus("MV");
		 mv.setNext(mInges);
		 mInges.setStatus("Inges");
		 mInges.setNext(mFileCreate);
		 mFileCreate.setStatus("FC");
		 mv.handleNextProcess("Customer Handler called -", cust);
	}

	public void processSalesSteps(Sales sales) {
		// TODO Auto-generated method stub
		 mv.setStatus("MV");
		 mv.setNext(mInges);
		 mInges.setStatus("Inges");
		 mInges.setNext(mFileCreate);
		 mFileCreate.setStatus("FC");
		 mv.handleNextProcess("Sales Handler called -", sales);
	}
	
}
