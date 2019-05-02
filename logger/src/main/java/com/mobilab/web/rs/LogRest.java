package com.mobilab.web.rs;

import com.mobilab.web.client.TransactionClient;
import com.mobilab.web.model.Transaction;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/log")
public class LogRest {

    private final TransactionClient transactionClient;

    @Autowired
    public LogRest(TransactionClient transactionClient) {
        this.transactionClient = transactionClient;
    }

    @ApiOperation(value = "get transactions")
    @RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<Transaction>> findById() {
        return new ResponseEntity<>(transactionClient.getList().getBody(), HttpStatus.OK);
    }

}
