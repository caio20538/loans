package com.caio.loans.controller.dto.response;

import com.caio.loans.domain.LoanType;

public record LoanResponse(LoanType type, Double interestRate) {
}
