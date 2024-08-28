package com.aptiva.model;

import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GPSDataMessage {
	String customerId;
	String carID;
	String officeID;
	String agentID;
	Date timeStamp;
	String carMovementStatus;
	Double currLongitude;
	Double currLatitude;
	String currArea;
	Double currKilometers;
}
