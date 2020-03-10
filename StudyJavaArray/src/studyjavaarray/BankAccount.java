/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavaarray;

/**
 *
 * @author Khaitong Lim
 */
public class BankAccount implements Comparable<BankAccount>{

    private long accountNumber;
    private String name;
    private double balance;
    private int accountStatus;

    public BankAccount() {
    }
    
    @Override
    public int compareTo(BankAccount ba) {
        // x.compareTo(y)
        if (this.balance>ba.balance) {
            return 1;
        } else if (this.balance < ba.balance) {
            return -1;
        }
        return 0;
    }
    
    public BankAccount(long accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.updateStatus();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountStatus() {
        if (this.accountStatus == 1) {
            return "Good";
        }
        return "Low";
    }

    private void updateStatus() {
        this.accountStatus = 0;
        if (this.balance > 100_000) {
            this.accountStatus = 1;
        }
    }

    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        }
        this.balance = this.balance + amount;
        this.updateStatus();
        return true;
    }

    public boolean withdraw(double amount) {
//        if (amount < 0 || amount > this.balance) {
//            return false;
//        }
        if (amount < 0) {
            return false;
        }
        if (amount > this.balance) {
            return false;
        }
        this.balance = this.balance - amount;
        this.updateStatus();
        return true;
    }


    public String toString() {
        return accountNumber + ": "+ balance ;
    }
}
