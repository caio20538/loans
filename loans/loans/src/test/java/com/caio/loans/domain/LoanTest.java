package com.caio.loans.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class LoanTest {

    @Mock
    private Customer customer;

    @InjectMocks
    private Loan loan;

    @Nested
    class isPersonalLoanAvailable{

        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLess3k() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertTrue(loan.isPersonalLoanAvailable() );
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd4kAndAgeIsLessThen30AndLocationsIsSP() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.00);
            doReturn(true).when(customer).isIncomeBetween(3000.00, 5000.00);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isPersonalLoanAvailable() );
        }
    }

    @Nested
    class isConsignmentLoanAvailable{

        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrGreater5k() {
            doReturn(true).when(customer).isIncomeEqualOrGraterThan(5000.00);

            assertTrue(loan.isConsignmentLoanAvailable() );
        }

        @Test
        void shouldNotBeAvailableWhenIncomeIsEqualTo4k() {
            doReturn(false).when(customer).isIncomeEqualOrGraterThan(5000.00);

            assertFalse(loan.isConsignmentLoanAvailable());
        }


    }

    @Nested
    class isGuaranteedLoanAvailable{

        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLess3k() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertTrue(loan.isGuaranteedLoanAvailable() );
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd4kAndAgeIsLessThen30AndLocationsIsSP() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.00);
            doReturn(true).when(customer).isIncomeBetween(3000.00, 5000.00);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isGuaranteedLoanAvailable());
        }
    }

    @Nested
    class getPersonalLoanInterestRate {
        @Test
        void shouldTheInterestRateBe4() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertEquals(4.0,loan.getPersonalLoanInterestRate());
        }

        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertThrows(LoanNotAvailableException.class,() -> loan.getPersonalLoanInterestRate());
        }
    }

    @Nested
    class getGuaranteeLoanInterestRate {
        @Test
        void shouldTheInterestRateBe3() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertEquals(3.0,loan.getGuaranteeLoanInterestRate());
        }

        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertThrows(LoanNotAvailableException.class,() -> loan.getGuaranteeLoanInterestRate());
        }
    }

    @Nested
    class getConsignmentLoanInterestRate {
        @Test
        void shouldTheInterestRateBe2() {
            doReturn(true).when(customer).isIncomeEqualOrGraterThan(5000.00);

            assertEquals(2.0,loan.getConsignmentLoanInterestRate());
        }

        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {
            doReturn(false).when(customer).isIncomeEqualOrGraterThan(5000.00);

            assertThrows(LoanNotAvailableException.class,() -> loan.getConsignmentLoanInterestRate());
        }
    }

}