package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void addNewBranch(String name) {
        if (findBranch(name) < 0) {
            Branch branch = Branch.createBranch(name);
            System.out.println("Branch successfully added ");
            branches.add(branch);

        } else if(findBranch(name) >= 0) {
            System.out.println("Branch already exists");
        }
    }

    public Customer addCustomerToBranch(String name, Branch branch) {
        if (findBranch(branch.getName()) >= 0) {
            Customer customer = branch.addCustomer(name);

            return customer;

        }
        return null;
    }

    public Customer addCustomerToBranch(String name, String branchName) {
        if (findBranch(branchName) >= 0) {
            Branch branch = branches.get(findBranch(branchName));
            Customer customer = branch.addCustomer(name);

            return customer;

        }
        if (findBranch(branchName) < 0) {
            System.out.println("There is no such branch!");
        }
        return null;
    }

    public void addTransactionToCustomer(Branch branch, Customer customer, double amount) {
        if (findBranch(branch) >= 0) {
            branch.transaction(customer, amount);
        }
    }

    public void addTransactionToCustomer(String branchName, String customerName, double amount) {
        if (findBranch(branchName) >= 0) {
            Branch branch = branches.get(findBranch(branchName));
            branch.transaction(customerName, amount);
        }
    }

    public Branch createBranch(String name) {
        return Branch.createBranch(name);

    }

    public void printCustomers(String branchName) {
        if (findBranch(branchName) >= 0) {
            System.out.println(branchName + " has these Customers: ");
            Branch branch = branches.get(findBranch(branchName));
            for (int i = 0; i < branch.getCustomerArrayList().size(); i++) {
                Customer customer = branch.getCustomerArrayList().get(i);
                System.out.println(customer.getName());
                for (int j = 0; j < customer.getTransactions().size(); j++) {
                    double transaction = customer.getTransactions().get(j);
                    System.out.println((i + 1) + ".  Transaction: " + transaction);
                }
            }
        }
    }

    private int findBranch(String name) {
        for (int i = 0; i < branches.size(); i++) {
            String branchName = branches.get(i).getName();

            if (branchName.equals(name)) {

                return i;
            }
        }

        return -1;
    }

    private int findBranch(Branch branch) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i) != null) {
                return i;
            }
        }
        return -1;
    }
}
