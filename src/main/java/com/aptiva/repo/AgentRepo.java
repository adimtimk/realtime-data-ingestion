package com.aptiva.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.aptiva.model.Agent;
import com.aptiva.model.Customer;
@Repository
public interface AgentRepo  extends CassandraRepository<Agent, Integer>{

}
