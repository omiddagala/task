package com.mobilab.accounting.web.rs;

import com.mobilab.accounting.web.dto.AccountDTO;
import com.mobilab.accounting.web.dto.TransferDTO;
import com.mobilab.accounting.web.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class AccountingRest {

    private final AccountService accountService;

    @Autowired
    public AccountingRest(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createAccount(@RequestBody AccountDTO accountDTO) {
        accountService.create(accountDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/charge", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> chargeAccount(@RequestBody AccountDTO accountDTO) {
        accountService.chargeAccount(accountDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> withdrawFromAccount(@RequestBody AccountDTO accountDTO) {
        accountService.withdrawFromAccount(accountDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> transfer(@RequestBody TransferDTO transferDTO) {
        accountService.transfer(transferDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}