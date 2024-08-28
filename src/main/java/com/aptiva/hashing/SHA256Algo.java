package com.aptiva.hashing;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import com.aptiva.model.FileTransactions;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class SHA256Algo implements HashingAlgo {

	@Override
	public FileTransactions applyHashing(FileTransactions msg, String hashType) {
		// TODO Auto-generated method stub
		
		String mobileNumber = msg.getCustmobileNum();
		String custName = msg.getName();
		String salt = "saltnpepper";
		
		String sha256Str = DigestUtils.sha256Hex(mobileNumber+salt+custName);
		((FileTransactions)msg).setCustmobileNum(sha256Str);
		FileTransactions hashedObj = msg;
		
		log.info("hashed object : {} - {} - {}",hashedObj.getCustmobileNum(),hashedObj.getCarMovementStatus(),hashedObj.getGpsTxnID());
		return hashedObj ;
	}

}
