package com.aptiva.cors.handlers;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aptiva.model.FileTracker;
import com.aptiva.model.FileTransactions;
import com.aptiva.repo.FileTrackerRepo;
import com.aptiva.repo.FileTransactionRepo;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import lombok.extern.log4j.Log4j2;
@Component
@Log4j2
public class FileCreationHanlder {
	@Value("${app.file.inbox.path}")
	private String filePath;

	@Autowired
	private FileTransactionRepo ftxnRepo;
	@Autowired
	private FileTrackerRepo fttrackeRepo;
	
	public String generateFile(List<FileTransactions> fileObjects) {
		String batchIdForFile = UUID.randomUUID().toString().replace("-", "");
//		for(FileTransactions files : fileObjects) {
//			files.setBatchId(batchIdForFile);
//		}
		String CSV_LOCATION = batchIdForFile + ".csv";
		try {
			FileWriter writer = new FileWriter(CSV_LOCATION);
			ColumnPositionMappingStrategy<FileTransactions> mappingStrategy = new ColumnPositionMappingStrategy<FileTransactions>();
			mappingStrategy.setType(FileTransactions.class);
			String[] columns = { "batchId", "carMaker", "carModel", "carPlateNum", "carRegisDate",
					"carExpiryDate", "officeId", "mobileNum", "area", "ofNum", "officeHrs", "carId", "salesDateTxn",
					"salesAmount", "salesId", "custmobileNum", "name", "gender", "age", "nationality", "passportNum",
					"idNum", "leaseStartDate", "leaseEndDate", "leasePeriod", "city", "code", "custarea", "gpsTxnID",
					"timeStamp", "carMovementStatus", "currLongitude", "currLatitude", "currArea", "currKilometers",
					"recordStatus", "agentId", "agmobileNum", "agname", "aggender", "agage", "agnationality",
					"agofficeId" };

			mappingStrategy.setColumnMapping(columns);
			
			// Creating StatefulBeanToCsv object
			StatefulBeanToCsvBuilder<FileTransactions> builder = new StatefulBeanToCsvBuilder<FileTransactions>(writer);
			StatefulBeanToCsv<FileTransactions> beanWriter = builder.withMappingStrategy(mappingStrategy).build();

			
			// Write list to StatefulBeanToCsv object
			beanWriter.write(fileObjects);

			// closing the writer object
			writer.close();

		} catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			return "";
			
		}

		return batchIdForFile;
	}

	public boolean updateTracker(String isSuccess) {
		// TODO Auto-generated method stub
			FileTracker ft = new FileTracker();
			ft.setBatchId(isSuccess);
			ft.setFileStatus("CREATED-SENT");
			ft.setFileCreatedDate(Timestamp.from(Instant.now()));
			
			FileTracker saved = fttrackeRepo.save(ft);
		return saved.getBatchId().length()>0;
	}

	public boolean saveCommonFileRecordsToDB(List<FileTransactions> fileList) {
		log.info("File for save to db {}",fileList);
		// TODO Auto-generated method stub
		List<FileTransactions> saved = ftxnRepo.saveAll(fileList);;
		return !saved.isEmpty();
	}

}
