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

    public void addNewBranch(Branch branch) {
        if (findBranch(name) <= 0) {
            System.out.println("Branch successfully added ");
            branches.add(branch);

        }

    }

    public Customer addCustomerToBranch(String name, Branch branch) {
        if (findBranch(branch.getName()) >= 0) {
            Customer customer = branch.addCustomer(name);

            System.out.println("Successfully customer with name " + name + " added to branch " + branch.getName());
            return customer;

        }
        return null;
    }

    public void addTransactionToCustomer(Branch branch, Customer customer, double amount) {
        if (findBranch(branch) >= 0) {
            branch.transaction(customer, amount);
        }
    }

    public Branch createBranch(String name) {
        return Branch.createBranch(name);

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
