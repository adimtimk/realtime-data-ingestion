package com.aptiva.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.aptiva.cors.MessageEnrichmentHandler;
import com.aptiva.cors.MessageFileCreationHandler;
import com.aptiva.cors.MessageFiltrationAndTxnIngestionHandler;
import com.aptiva.cors.MessageHashingHandler;
import com.aptiva.cors.MessageIngestionHandler;
import com.aptiva.cors.MessageUtils;
import com.aptiva.cors.MessageValidationHandler;
import com.aptiva.model.GPSData;
import com.aptiva.model.GPSDataMessage;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class GPSDataListner {
	@Autowired
	private MessageUtils messageUtils;
	
	
	@KafkaListener(groupId = "gps-grp-1",topics ="#{'${gps.topic}'}" )
	public void consume(GPSData gps) {
		 log.info("GPSData consume the events {} ", gps.toString());
//		 MessageIngestionHandler mInges = new MessageIngestionHandler();
		 messageUtils.processGPSSteps(gps);
	 

	}

	
	
	
}
