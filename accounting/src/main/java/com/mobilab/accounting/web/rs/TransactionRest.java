package com.mobilab.accounting.web.rs;

import com.mobilab.accounting.web.model.Transaction;
import com.mobilab.accounting.web.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/transaction")
public class TransactionRest {

    private final TransactionService transactionService;

    @Autowired
    public TransactionRest(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<Transaction>> createAccount() {
        return new ResponseEntity<>(transactionService.getList(), HttpStatus.OK);
    }
}
