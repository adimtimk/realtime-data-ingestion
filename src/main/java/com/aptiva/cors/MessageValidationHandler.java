package com.aptiva.cors;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.aptiva.cors.validate.JsonValidation;
import com.aptiva.model.Customer;
import com.aptiva.model.GPSData;
import com.aptiva.model.Sales;
import com.networknt.schema.ValidationMessage;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2

public class MessageValidationHandler extends MessageHandler {

	@Override
	public void handleNextProcess(String processname, Object message) {
		// TODO Auto-generated method stub
		Set<ValidationMessage> errors = null;
		if (message instanceof GPSData) {
			List<GPSData> badRecords = new ArrayList<>();

			log.info("Start validating GPS data {}", ((GPSData) message).getCustomerId());
			errors = JsonValidation.validateJsonMessage((GPSData) message,"GPS");
			log.info("erros - {}", errors);
			if (errors.size() > 1) {
				badRecords.add((GPSData) message);
			}

		}
		
		if (message instanceof Sales) {
			List<Sales> badRecords = new ArrayList<>();

			log.info("Start validating Sales data {}", ((Sales) message).getCustomerId());
			errors = JsonValidation.validateJsonMessage((Sales) message,"Sales");
			log.info("erros - {}", errors);
			if (errors.size() > 1) {
				badRecords.add((Sales) message);
			}

		}
		if (message instanceof Customer) {
			List<Customer> badRecords = new ArrayList<>();

			log.info("Start validating Customer data {}", ((Customer) message).getCustomerId());
			errors = JsonValidation.validateJsonMessage((Customer) message,"Customer");
			log.info("erros - {}", errors);
			if (errors.size() > 1) {
				badRecords.add((Customer) message);
			}

		}
		if (errors.size() == 0) {
			if (!status.equals("FC")) {
				next.handleNextProcess(processname, message);
			} 
		}else {
			log.info("error prone - skip msgs{}",  message);
		}
	}

}
