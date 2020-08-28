package com.company;


import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Bank bank = new Bank("Nu tik būs");

    public static void main(String[] args) {

        Branch branch1 = bank.createBranch("Branch1");
        bank.addNewBranch("Branch1");
        Customer customer = bank.addCustomerToBranch("Silva", branch1);
        bank.addTransactionToCustomer(branch1, customer, 40);
        bank.addTransactionToCustomer(branch1, customer, -50);
        branch1.printCustomers(branch1.getCustomerArrayList());
        branch1.printCustomersWithTransactions(customer);

        System.out.println("______________________________________");

        bank.addNewBranch("Adelaine");
        bank.addCustomerToBranch("Tim", "Adelaine");
        bank.addCustomerToBranch("Tom", "Adelaine");
        bank.addCustomerToBranch("Tem", "Adelaine");

        bank.addNewBranch("Sydney");
        bank.addCustomerToBranch("Ren", "Sydney");

        bank.addTransactionToCustomer("Adelaine", "Tim", 44.22);
        bank.addTransactionToCustomer("Adelaine", "Tim", 12.44);
        bank.addTransactionToCustomer("Adelaine", "Tem", 1.65);

        bank.printCustomers("Adelaine");

        bank.addCustomerToBranch("Soap", "Bath");
        bank.addNewBranch("Adelaine");


    }
}
