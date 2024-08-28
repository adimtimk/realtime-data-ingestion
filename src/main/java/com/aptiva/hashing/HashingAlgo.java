package com.aptiva.hashing;

import com.aptiva.model.FileTransactions;

public interface HashingAlgo {

	FileTransactions applyHashing(FileTransactions msg,String hashType);
}
