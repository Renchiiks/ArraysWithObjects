package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<>();
    private double moneyInAcc;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public double getMoneyInAcc() {
        return moneyInAcc;
    }

    public static Customer createCustomer(String name) {
        System.out.println("New costumer with name " + name + " created");
        return new Customer(name);
    }

    private boolean transactionCheck(double money) {
        if (this.moneyInAcc - Math.abs(money) < 0) {
            System.out.println("Not enough money in account");
            return false;
        } else {
            this.moneyInAcc -= money;
            return true;
        }
    }

    public boolean transaction(double money) {
        transactions.add(money);
        if (money >= 0) {
            this.moneyInAcc += money;

            return true;
        }

        if (money < 0) {
            if (transactionCheck(money)) {

                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
