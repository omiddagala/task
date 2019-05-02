package com.mobilab.accounting.web.service;

import com.mobilab.accounting.web.model.Transaction;
import com.mobilab.accounting.web.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
@Transactional
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public ArrayList<Transaction> getList(){
        ArrayList<Transaction> list = new ArrayList<>();
        Iterable<Transaction> iterator = transactionRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
        iterator.forEach(list::add);
        return list;
    }
}
