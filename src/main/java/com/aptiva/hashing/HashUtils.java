package com.aptiva.hashing;

import org.springframework.stereotype.Component;

@Component
public class HashUtils {

	public HashingAlgo getHashedAlgo(String type) {
		if(type.equals("SHA256")) {
			return	new SHA256Algo();
		}
		return	new SHA256Algo();
	}
}
