package com.aptiva.cors.handlers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptiva.model.Agent;
import com.aptiva.model.Car;
import com.aptiva.model.Customer;
import com.aptiva.model.FileTracker;
import com.aptiva.model.FileTransactions;
import com.aptiva.model.GPSData;
import com.aptiva.model.Office;
import com.aptiva.model.Sales;
import com.aptiva.repo.AgentRepo;
import com.aptiva.repo.CarRepo;
import com.aptiva.repo.CustomerRepo;
import com.aptiva.repo.FileTrackerRepo;
import com.aptiva.repo.FileTransactionRepo;
import com.aptiva.repo.OfficeRepo;
import com.aptiva.repo.SalesRepo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FileTransactionHanlder {
	@Autowired
	private CarRepo carRepo;
	@Autowired
	private AgentRepo agentRepo;
	@Autowired
	private OfficeRepo officeRepo;
	@Autowired
	private SalesRepo salesrepo;
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private FileTrackerRepo trackerRepo;
	@Autowired
	private FileTransactionRepo fileTransactionRepo;

	public FileTransactions processEnrichment(GPSData message) {
		// TODO Auto-generated method stub
		log.info("processEnrichment started");
		// get the cardata
		Optional<Car> currCarData = carRepo.findById(message.getCarID());
		// get the agent data
		Optional<Agent> currAgentData = agentRepo.findById(message.getAgentID());
		// get the customer data
		Optional<Customer> currCustomerData = customerRepo.findById(message.getCustomerId());
		// get officedata
		Optional<Office> currOfficeData = officeRepo.findById(message.getOfficeID());

		Sales currSalesData = salesrepo.findByAgentIdAndOfficeIdAndCarIDAndCustomerId(message.getAgentID(),
				message.getOfficeID(), message.getCarID(), message.getCustomerId());

		log.info("Data from gps and db {}-{}-{}-{}", currSalesData, currOfficeData, currAgentData, currCarData,
				currCustomerData);
		String FileTxnIdForFile = UUID.randomUUID().toString().replace("-", "");
		FileTransactions fileTxnObj = FileTransactions.builder().age(currCustomerData.get().getAge())
				.custarea(currCustomerData.get().getArea()).custmobileNum(currCustomerData.get().getMobileNum())
				.gender(currCustomerData.get().getGender()).nationality(currCustomerData.get().getNationality())
				.passportNum(currCustomerData.get().getPassportNum()).idNum(currCustomerData.get().getIdNum())
				.leaseStartDate(currCustomerData.get().getLeaseStartDate())
				.leaseEndDate(currCustomerData.get().getLeaseEndDate())
				.leasePeriod(currCustomerData.get().getLeasePeriod()).city(currCustomerData.get().getCity())
				.code(currCustomerData.get().getCode()).carId(currCarData.get().getCarId())
				.carMaker(currCarData.get().getCarMaker()).carModel(currCarData.get().getCarModel())
				.carRegisDate(currCarData.get().getCarRegisDate()).carExpiryDate(currCarData.get().getCarExpiryDate())
				.carPlateNum(currCarData.get().getCarPlateNum()).officeHrs(currOfficeData.get().getOfficeHrs())
				.officeId(currOfficeData.get().getOfficeId()).ofNum(currOfficeData.get().getOfNum())
				.area(currOfficeData.get().getArea()).mobileNum(currOfficeData.get().getMobileNum())
				.agage(currAgentData.get().getAge()).agentId(currAgentData.get().getAgentId())
				.aggender(currAgentData.get().getGender()).agmobileNum(currAgentData.get().getMobileNum())
				.agnationality(currAgentData.get().getNationality()).agofficeId(currAgentData.get().getOfficeId())
				.gpsTxnID(message.getGpsTxnID()).carMovementStatus(message.getCarMovementStatus())
				.currArea(message.getCurrArea()).currKilometers(message.getCurrKilometers())
				.currLatitude(message.getCurrLatitude()).currLongitude(message.getCurrLongitude())
				.timeStamp(message.getGtimeStamp())
				.salesAmount(currSalesData.getSalesAmount())
				.salesDateTxn(currSalesData.getSalesDateTxn())
				.salesId(currSalesData.getSalesId())
				.agname(currAgentData.get().getName())
				.custId(message.getCustomerId())
				.fileTxnId(FileTxnIdForFile)
				.build();

		return fileTxnObj;

	}

}
