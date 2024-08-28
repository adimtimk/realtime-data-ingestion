package com.aptiva.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesDataMapper {
//AgentID, OfficeID, CarID, CustomerID, Amount (USD)
	private Integer agentId;
	private Integer officeId;
	private Integer carID;
	private Integer customerId;
	private Date salesDateTxn;
	private Double salesAmount;
	
}
