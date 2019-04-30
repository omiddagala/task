package com.mobilab.accounting.web.service;

import com.mobilab.accounting.web.dto.AccountDTO;
import com.mobilab.accounting.web.dto.TransferDTO;
import com.mobilab.accounting.web.model.Account;
import com.mobilab.accounting.web.model.Transaction;
import com.mobilab.accounting.web.repository.AccountRepository;
import com.mobilab.accounting.web.repository.TransactionRepository;
import com.mobilab.accounting.web.utils.currency.CurrencyConverter;
import com.mobilab.accounting.web.utils.currency.CurrencyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public void save(Account account) {
        accountRepository.save(account);
    }

    public Account findByAccountId(String accountId) {
        return accountRepository.findByAccountId(accountId);
    }

    public void create(AccountDTO accountDTO) {
        Account account = new Account();
        account.setName(accountDTO.getName());
        account.setAccountId(accountDTO.getAccountId());
        account.setCurrencyType(accountDTO.getCurrencyType());
        accountRepository.save(account);
    }

    public void withdrawFromAccount(AccountDTO accountDTO) {
        Account account = accountRepository.findByAccountId(accountDTO.getAccountId());
        CurrencyConverter currencyConverter = CurrencyFactory.getCurrencyFactory(account.getCurrencyType());
        Double convertedSource = currencyConverter.convert(accountDTO.getCurrencyType(), accountDTO.getAmount());
        Double newAmount = account.getAmount() - convertedSource;
        account.setAmount(newAmount);
        accountRepository.save(account);
    }

    public void chargeAccount(AccountDTO accountDTO) {
        Account account = accountRepository.findByAccountId(accountDTO.getAccountId());
        CurrencyConverter currencyConverter = CurrencyFactory.getCurrencyFactory(account.getCurrencyType());
        Double convertedSource = currencyConverter.convert(accountDTO.getCurrencyType(), accountDTO.getAmount());
        Double newAmount = account.getAmount() + convertedSource;
        account.setAmount(newAmount);
        accountRepository.save(account);
    }

    public void transfer(TransferDTO transferDTO) {
        Account sourceAccount = accountRepository.findByAccountId(transferDTO.getSourceAccountId());
        Account destinationAccount = accountRepository.findByAccountId(transferDTO.getDestinationAccountId());
        CurrencyConverter currencyConverter = CurrencyFactory.getCurrencyFactory(destinationAccount.getCurrencyType());
        Double convertedSource = currencyConverter.convert(sourceAccount.getCurrencyType(), transferDTO.getAmount());
        Double newAmount = sourceAccount.getAmount() + convertedSource;
        sourceAccount.setAmount(newAmount);
        logTransaction(transferDTO);
        accountRepository.save(sourceAccount);
    }

    private void logTransaction(TransferDTO transferDTO) {
        Transaction transaction = new Transaction();
        transaction.setSourceAccountId(transferDTO.getSourceAccountId());
        transaction.setDestinationAccountId(transferDTO.getDestinationAccountId());
        transaction.setAmount(transferDTO.getAmount());
        transaction.setDate(LocalDate.now());
        transactionRepository.save(transaction);
    }

}
