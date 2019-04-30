package com.mobilab.accounting.web.repository;

import com.mobilab.accounting.web.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    Account findByAccountId(String accountId);
}