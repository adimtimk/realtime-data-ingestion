package com.aptiva.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.aptiva.model.FileTracker;
@Repository
public interface FileTrackerRepo  extends CassandraRepository<FileTracker, String> {

}
