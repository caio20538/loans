package com.caio.loans.controller.dto.response;

import java.util.List;

public record CustomerLoanResponse(String customer, List<LoanResponse> loan) {
}
