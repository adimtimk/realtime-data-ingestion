package com.aptiva.cors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aptiva.cors.handlers.FileCreationHanlder;
import com.aptiva.model.FileTransactions;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class MessageFiltrationAndTxnIngestionHandler extends MessageHandler {
	@Value("${app.file.filter.records.size}")
	private int filterFileRecordsSize;
	@Value("${app.file.db.common.size}")
	private int dbFileRecordsSize;
	@Autowired
	private FileCreationHanlder fc;

	public static List<FileTransactions> fileList = new ArrayList<>();
	public static List<FileTransactions> fileListWithFilter = new ArrayList<>();

	@Override
	public void handleNextProcess(String processname, Object message) {
		// TODO Auto-generated method stub
		FileTransactions hashedObject = (FileTransactions) message;
		// check for dubai city records
		log.info("Intial Size of fileListWithFilter {},fileList {} with gpstxnID {}",fileListWithFilter.size(), fileList.size(),
				hashedObject.getGpsTxnID());
		
		log.info("hashedObject.getCity() {} and hashedObject.Mobile {}",hashedObject.getCity(),hashedObject.getMobileNum());
		
			next.handleNextProcess(processname, hashedObject);
		
	}

}
