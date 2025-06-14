package com.caio.loans.domain;

import com.caio.loans.domain.factory.CustomerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


class CustomerTest {

    private final Customer customer = CustomerFactory.build(5000.00);

    @Nested
    class isIncomeEqualOrLowerThan {

        @Test
        void shouldBeTrueWhenIncomeIsEqual(){
            assertTrue(customer.isIncomeEqualOrLowerThan(5000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeLowerThan(){
            assertTrue(customer.isIncomeEqualOrLowerThan(9000.00));
        }

        @Test
        void shouldBeFalseWhenIncomeIsNotGraterThanValue(){
            assertFalse(customer.isIncomeEqualOrLowerThan(3000.00));
        }
    }

    @Nested
    class isIncomeEqualOrGraterThan {

        @Test
        void shouldBeTrueWhenIncomeIsEqual(){
            assertTrue(customer.isIncomeEqualOrGraterThan(5000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeGreaterThan(){
            assertTrue(customer.isIncomeEqualOrGraterThan(3000.00));
        }

        @Test
        void shouldBeFalseWhenIncomeIsNotLowerThanValue(){
            assertFalse(customer.isIncomeEqualOrGraterThan(9000.00));
        }
    }

    @Nested
    class isIncomeBetween {

        @Test
        void shouldBeTrueWhenIncomeIsBetween(){
            assertTrue(customer.isIncomeBetween(3000.00, 8000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualToMin(){
            assertTrue(customer.isIncomeBetween(5000.00, 8000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualToMax(){
            assertTrue(customer.isIncomeBetween(2000.00, 5000.00));
        }

        @Test
        void shouldBeFalseWhenIncomeIsNotBetween(){
            assertFalse(customer.isIncomeBetween(3000.00, 4500.00));
        }
    }

    @Nested
    class isAgeLowerThen {

        private final Customer customer = CustomerFactory.build(25);

        @Test
        void shouldBeTrueWhenAgeIsLowerThan(){
            assertTrue(customer.isAgeLowerThan(30));
        }

        @Test
        void shouldBeFalseWhenAgeIsNotLowerThan(){
            assertFalse(customer.isAgeLowerThan(20));
        }

        @Test
        void shouldBeFalseWhenAgeIsEqualThan(){
            assertFalse(customer.isAgeLowerThan(25));
        }
    }

    @Nested
    class isFromLocation {

        private final Customer customer = CustomerFactory.build("SP");

        @Test
        void shouldBeTrueWhenLocationIsEqualThaSame(){
            assertTrue(customer.isFromLocation("SP"));
        }

        @Test
        void shouldBeFalseWhenLocationIsNotEqualThaSame(){
            assertFalse(customer.isFromLocation("RJ"));
        }
    }
}