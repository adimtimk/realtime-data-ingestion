package com.aptiva.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.aptiva.cors.MessageUtils;
import com.aptiva.model.Sales;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SalesTxnListener {
	@Autowired
	private MessageUtils messageUtils;
	@Value("${sales.topic}")
    private String sales_topic;
	
	@KafkaListener(groupId = "sales-grp-1",topics ="#{'${sales.topic}'}" )
public void consume(Sales sales) {
		 log.info("Sales consume the events {} ", sales.toString());
		 messageUtils.processSalesSteps(sales);
	}
}
