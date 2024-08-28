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
@Table("SALES_TXN")
public class Sales {
//AgentID, OfficeID, CarID, CustomerID, Amount (USD)
	@PrimaryKey
	private Integer salesId;
	private Integer agentId;
	private Integer officeId;
	private Integer carID;
	private Integer customerId;
	private Timestamp salesDateTxn;
	private Double salesAmount;
	
}
