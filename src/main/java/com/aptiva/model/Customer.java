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
@Table("CUST_REF_DATA")
public class Customer {
//CustomerID, Mobile No, Name, Gender, Age, Nationality, PassportNo, ID No, Home Address,Lease Start Date, Lease Period
@PrimaryKey
private Integer customerId;
private String mobileNum;
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
private String area;



}
