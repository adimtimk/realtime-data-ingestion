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
@Table("AGENT_REF_DATA")
public class Agent {
	@PrimaryKey
	private Integer agentId;
	private String mobileNum;
	private String name;
	private String gender;
	private int age;
	private String nationality;
	private String officeId;
}
