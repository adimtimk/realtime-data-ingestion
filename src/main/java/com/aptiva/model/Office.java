package com.aptiva.model;

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
@Table("OFFICE_REF_DATA")
public class Office {
	@PrimaryKey
	private Integer officeId;
	private String mobileNum;
	private String area;
	private String ofNum;
	private String officeHrs;
}
