package com.aptiva.cors;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aptiva.cors.handlers.FileCreationHanlder;
import com.aptiva.model.FileTransactions;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class MessageFileCreationHandler extends MessageHandler {
	@Value("${app.file.db.common.size}")
	private int dbFileRecordsSize;
	@Value("${app.file.filter.records.size}")
	private int filterFileRecordsSize;
	@Autowired
	private FileCreationHanlder fc;
	public static List<FileTransactions> fileList = new ArrayList<>();
	public static List<FileTransactions> fileListwithFilter = new ArrayList<>();

	@Override
	public void handleNextProcess(String processname, Object message) {
		//boolean flagBatched=false;
		FileTransactions enrichedObject = (FileTransactions) message;
		// TODO Auto-generated method stub
		log.info("MessageFileCreationHandler done....");
		log.info("MessageFileCreationHandler.getCity() {} and hashedObject.Mobile {}", enrichedObject.getCity(),
				enrichedObject.getMobileNum());
		//String isSuccessBatchid=null;
		if(fileList.size()<10) {
			fileList.add(enrichedObject);
		}
		
		if(fileList.size()==10) {
			boolean isFileListSaved = fc.saveCommonFileRecordsToDB(fileList);
			// boolean isTracked = fc.updateTracker(isSuccessBatchid);
			if (isFileListSaved) {
				log.info("isFileListSaved before clear done....{}", fileListwithFilter);

				fileList.clear();
				fileList.add(enrichedObject);
			}
		}
		
	}
}
