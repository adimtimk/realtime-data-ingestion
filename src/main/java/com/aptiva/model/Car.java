package com.aptiva.model;

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
@Table("CAR_REF_DATA")
public class Car {
	@PrimaryKey
	private Integer carId;
	private String carMaker;
	private String carModel;
	private String carPlateNum;
	private Date carRegisDate;
	private Date carExpiryDate;
	
	
}
