package com.aptiva.model;

import java.sql.Timestamp;

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
@Table("FILE_TRACKER")
public class FileTracker {
	@PrimaryKey
	private String batchId;
	private String  fileStatus;
	private Timestamp fileCreatedDate;
}
