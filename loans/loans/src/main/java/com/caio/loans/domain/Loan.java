package com.caio.loans.domain;

public class Loan {

    private Customer customer;
    private final double MIN_LOAN = 3000.00;
    private final double MAX_LOAN = 5000.00;
    private final int MIN_AGE = 30;
    private final String LOCATION = "SP";
    private final double PERSONAL_LOAN = 4.0;
    private final double CONSIGNMENT_LOAN = 2.0;
    private final double GUARANTEED_LOAN = 3.0;


    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isPersonalLoanAvailable(){
        return basicLoanAvailable();
    }

    public double getPersonalLoanInterestRate(){
        if (isPersonalLoanAvailable())
            return PERSONAL_LOAN;
        throw new LoanNotAvailableException();
    }

    public boolean isConsignmentLoanAvailable(){
        return customer.isIncomeEqualOrGraterThan(MAX_LOAN);
    }

    public double getConsignmentLoanInterestRate(){
        if (isConsignmentLoanAvailable())
            return CONSIGNMENT_LOAN;
        throw new LoanNotAvailableException();
    }

    public boolean isGuaranteedLoanAvailable(){
        return basicLoanAvailable();
    }

    public double getGuaranteeLoanInterestRate(){
        if (isGuaranteedLoanAvailable())
            return GUARANTEED_LOAN;
        throw new LoanNotAvailableException();
    }

    private boolean basicLoanAvailable() {
        if(customer.isIncomeEqualOrLowerThan(MIN_LOAN))
            return true;

        return customer.isIncomeBetween(MIN_LOAN, MAX_LOAN)
                && customer.isAgeLowerThen(MIN_AGE)
                && customer.isFromLocation(LOCATION);
    }
}
