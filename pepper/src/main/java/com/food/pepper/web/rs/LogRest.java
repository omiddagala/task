package com.food.pepper.web.rs;

import com.food.pepper.web.model.AccountDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author maysam on 11/19/17.
 */
@RestController
@RequestMapping("/v1/log")
public class LogRest {

    @ApiOperation(value = "insert log")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> findById(@Valid @RequestBody AccountDTO dto) {
        System.out.println("this is called");
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

}
