package com.caio.loans.domain;

public class Customer {
    private Integer age;
    private String cpf;
    private String name;
    private Double income;
    private String location;

    public Customer(Integer age, String cpf, String name, Double income, String location) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.location = location;
    }

    public boolean isIncomeEqualOrLowerThan(double value) {
        return income <= value;
    }

    public boolean isIncomeEqualOrGraterThan(double value) {
        return income >= value;
    }

    public boolean isIncomeBetween(double minValue, double maxValue){
        return income >= minValue && income <= maxValue;
    }

    public boolean isAgeLowerThen(int age){
        return this.age < age;
    }

    public boolean isFromLocation(String location){
        return this.location.equalsIgnoreCase(location);
    }
}
