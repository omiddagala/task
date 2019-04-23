package com.food.accounting.web.rs;

import com.food.accounting.web.model.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/Transfer")
public class TransferRest {

    @Autowired
    Environment env;

    @RequestMapping(value = "/employeeToEmployee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> employeeToEmployee(@Valid @RequestBody AccountDTO dto) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}