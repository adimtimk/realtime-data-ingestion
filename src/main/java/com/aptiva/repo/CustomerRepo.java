package com.aptiva.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.aptiva.model.Customer;
@Repository
public interface CustomerRepo extends CassandraRepository<Customer, Integer>{

}
