package com.caio.loans.domain.factory;

import com.caio.loans.domain.Customer;

public class CustomerFactory {

    public static Customer build (){
        return new Customer(25, "123.456.789-00", "name", 5000.00, "sp");
    }

    public static Customer build (int age){
        return new Customer(age, "123.456.789-00", "name", 5000.00, "sp");
    }

    public static Customer build (String location){
        return new Customer(25, "123.456.789-00", "name", 5000.00, location);
    }

    public static Customer build (double income){
        return new Customer(25, "123.456.789-00", "name", income, "sp");
    }
}
