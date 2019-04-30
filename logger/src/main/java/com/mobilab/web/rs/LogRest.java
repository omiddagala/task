package com.mobilab.web.rs;

import com.mobilab.web.client.AccountingClient;
import com.mobilab.web.model.AccountDTO;
import com.mobilab.web.model.CurrencyType;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/log")
public class LogRest {

    private final AccountingClient accountingClient;

    @Autowired
    public LogRest(AccountingClient accountingClient) {
        this.accountingClient = accountingClient;
    }

    @ApiOperation(value = "insert log")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> findById(@Valid @RequestBody AccountDTO dto) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId("11");
        accountDTO.setCurrencyType(CurrencyType.EUR);
        accountDTO.setName("omid");
        accountingClient.transfer(accountDTO);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

}
