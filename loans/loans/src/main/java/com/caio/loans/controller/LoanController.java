package com.caio.loans.controller;

import com.caio.loans.controller.dto.request.CustomerLoanRequest;
import com.caio.loans.controller.dto.response.CustomerLoanResponse;
import com.caio.loans.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping(value = "/customer-loans")
    public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody @Valid CustomerLoanRequest loanRequest){
        var loanResponse = loanService.checkLoanAvailability(loanRequest);

        return ResponseEntity.ok(loanResponse);
    }
}
