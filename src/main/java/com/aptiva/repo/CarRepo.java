package com.aptiva.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.aptiva.model.Car;
@Repository
public interface CarRepo  extends CassandraRepository<Car, Integer>{

}
