package com.aptiva.cors;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aptiva.model.Customer;
import com.aptiva.model.GPSData;
import com.aptiva.model.GPSDataMessage;
import com.aptiva.model.Sales;
import com.aptiva.service.CustomerTxnIngestionService;
import com.aptiva.service.GPSTxnIngestionSerice;
import com.aptiva.service.SalesTxnIngestionService;

import lombok.Builder;
import lombok.extern.log4j.Log4j2;
@Component
@Log4j2
public class MessageIngestionHandler extends MessageHandler { 
	@Autowired
	private GPSTxnIngestionSerice ingestion;
	@Autowired
	private SalesTxnIngestionService salesIngestion;
	@Autowired
	private CustomerTxnIngestionService custIngestion;
	
	@Override
	public void handleNextProcess(String processname, Object message) {
		// TODO Auto-generated method stub
		if(message instanceof GPSData) {
			log.info("Start Ingesting GPS data {}",((GPSData)message).getCustomerId());
			ingestion.savetoDBGPSTXN((GPSData)message);
		}
		if(message instanceof Sales) {
			
			log.info("Start Ingesting Sales data {}",((Sales)message).getSalesDateTxn());
	
		    salesIngestion.savetoSalesTXN((Sales)message);
		}
		if(message instanceof Customer) {
			log.info("Start Ingesting Customer data {}",((Customer)message).getCustomerId());
			custIngestion.savetoDBCustTXN((Customer)message);
		}
		if(!status.equals("FC")){
			next.handleNextProcess(processname, message);
		}
	}
}


