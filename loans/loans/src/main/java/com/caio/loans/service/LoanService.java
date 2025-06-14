package com.caio.loans.service;

import com.caio.loans.controller.dto.request.CustomerLoanRequest;
import com.caio.loans.controller.dto.response.CustomerLoanResponse;
import com.caio.loans.controller.dto.response.LoanResponse;
import com.caio.loans.domain.Loan;
import com.caio.loans.domain.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest loanRequest){
        var customer = loanRequest.toCustomer();
        Loan loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if (loan.isPersonalLoanAvailable())
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));

        if (loan.isConsignmentLoanAvailable())
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));

        if (loan.isGuaranteedLoanAvailable())
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteeLoanInterestRate()));

        return new CustomerLoanResponse(loanRequest.name(), loans);
    }
}
