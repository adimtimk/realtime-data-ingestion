package com.aptiva.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.aptiva.model.Office;
@Repository
public interface OfficeRepo  extends CassandraRepository<Office, Integer>{

}
