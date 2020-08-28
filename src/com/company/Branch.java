package com.company;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customerArrayList = new ArrayList<>();
    private ArrayList<Double> transactionsInBranch = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    public ArrayList<Double> getTransactionsInBranch() {
        return transactionsInBranch;
    }

    public void printCustomers(ArrayList<Customer> customerList) {

        for (int i = 0; i < customerArrayList.size(); i++) {
            System.out.println(customerArrayList.get(i).getName());
        }
    }


    public void printCustomersWithTransactions(Customer customer) {
        int count = 0;
        System.out.println("Customer " + customer.getName() + " has " + customer.getTransactions().size() + " transaction ");

        ArrayList<Double> transactions = customer.getTransactions();

        for (int j = 0; j < transactions.size(); j++) {
            count++;
            double transaction = transactions.get(j);
            System.out.println((j + 1) + ". Transaction: " + transaction + ", ");


        }
    }

    public static Branch createBranch(String name) {
        System.out.println("New branch with name " + name + " created");
        return new Branch(name);
    }

    public Customer addCustomer(String name) {
        if (findCustomer(name) <= 0) {
            Customer customer = Customer.createCustomer(name);
            customerArrayList.add(customer);
            System.out.println("Customer successfully added to branch " + getName());

            return customer;
        }


        System.out.println("Customer already exists");
        return null;
    }

    public void addCustomer(Customer customer) {
        customerArrayList.add(customer);
    }

    public void transaction(Customer customer, double amount) {
        if (findCustomer(customer.getName()) >= 0) {

            if (customer.transaction(amount)) {
                transactionsInBranch.add(amount);
                System.out.println("Transaction successful");

            } else {
                System.out.println("Transaction not successful");
            }
        }
    }

    public void transaction(String customer, double amount) {
        if (findCustomer(customer) >= 0) {
            Customer existingCustomer = customerArrayList.get(findCustomer(customer));
            if (existingCustomer.transaction(amount)) {
                transactionsInBranch.add(amount);
                System.out.println("Transaction successful");

            } else {
                System.out.println("Transaction not successful");
            }
        }
    }

    private int findCustomer(String name) {
        for (int i = 0; i < customerArrayList.size(); i++) {
            String customerName = customerArrayList.get(i).getName();

            if (customerName.equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
