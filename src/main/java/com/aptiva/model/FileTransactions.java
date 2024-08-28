package com.aptiva.model;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("FILE_TXNS")
public class FileTransactions {
	@PrimaryKey
	private String fileTxnId;
	private String fileBatchId;
	private String carMaker;
	private String carModel;
	private String carPlateNum;
	private Date carRegisDate;
	private Date carExpiryDate;
	private Integer officeId;
	private String mobileNum;
	private String area;
	private String ofNum;
	private String officeHrs;
	private Integer carId;
	private Timestamp salesDateTxn;
	private Double salesAmount;
	private Integer salesId;
	private String custmobileNum;
	private String name;
	private String gender;
	private int age;
	private String nationality;
	private String passportNum;
	private String idNum;
	private Timestamp leaseStartDate;
	private Timestamp leaseEndDate;
	private int leasePeriod;
	private String city;
	private String code;
	private String custarea;
	private Integer gpsTxnID;
	private Date timeStamp;
	private String carMovementStatus;
	private Double currLongitude;
	private Double currLatitude;
	private String currArea;
	private Double currKilometers;
	private String recordStatus;
	private Integer agentId;
	private String agmobileNum;
	private String agname;
	private String aggender;
	private int agage;
	private String agnationality;
	private String agofficeId;
	private Integer custId;
}
