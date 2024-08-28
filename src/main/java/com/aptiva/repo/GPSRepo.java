package com.aptiva.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.aptiva.model.GPSData;
@Repository
public interface GPSRepo extends CassandraRepository<GPSData, Integer>{

}
