package com.aptiva.cors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aptiva.hashing.HashUtils;
import com.aptiva.hashing.HashingAlgo;
import com.aptiva.model.Customer;
import com.aptiva.model.FileTransactions;
import com.aptiva.model.GPSData;
import com.aptiva.model.Sales;

import lombok.Builder;
import lombok.extern.log4j.Log4j2;
@Component
@Log4j2

public class MessageHashingHandler extends MessageHandler {
	@Value("${app.security.mask.mobilenumber}")
    private boolean is_masking_enabled;
	@Value("${app.security.mask.algo}")
    private String hash_algo;
	@Autowired
	private HashUtils hashUtils;
	@Override
	public void handleNextProcess(String processname, Object message) {
		// TODO Auto-generated method stub
		//depending on security flag hash the mobile number or else leave
		FileTransactions hashedObj=null;
		if(is_masking_enabled) {
			//for masking  
			FileTransactions enrichedObject = (FileTransactions)message;
			HashingAlgo hash = hashUtils.getHashedAlgo(hash_algo);
			message = hash.applyHashing(enrichedObject,hash_algo);
			hashedObj= (FileTransactions)message;
		}
		else {
			//no masking move aheas
		}
		
		
		if(!status.equals("FC")){
			next.handleNextProcess(processname, hashedObj);
		}
	} 

}
