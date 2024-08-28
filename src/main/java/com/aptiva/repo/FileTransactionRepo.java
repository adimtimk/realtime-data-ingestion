package com.aptiva.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.aptiva.model.FileTransactions;

public interface FileTransactionRepo  extends CassandraRepository<FileTransactions, String>{

}
