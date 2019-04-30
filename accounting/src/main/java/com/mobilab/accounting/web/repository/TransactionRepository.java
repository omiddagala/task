package com.mobilab.accounting.web.repository;

import com.mobilab.accounting.web.model.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
}
