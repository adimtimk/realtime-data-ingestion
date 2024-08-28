package com.aptiva.repo;

import java.util.Optional;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.aptiva.model.Sales;
@Repository

public interface SalesRepo extends CassandraRepository<Sales, Integer> {
	//	Sales findByagentIdAndofficeIdAndcarIDAndcustomerId(Integer agentId,Integer officeId,Integer carID,Integer customerId);
		@AllowFiltering
		Sales findByAgentIdAndOfficeIdAndCarIDAndCustomerId(int agentID, int officeID, int carID,
				int customerId);
}
