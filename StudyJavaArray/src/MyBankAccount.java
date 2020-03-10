/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khaitong Lim
 */
public class MyBankAccount {

    private int accountNumber;
    private String name;
    private double balance;
    private int accountStatus;

    public MyBankAccount() {
    }

    public MyBankAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        updateStatus();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
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

    public boolean withdraw(double amount) {
        if (amount < 0) {
            return false;
        }
        if(amount>this.balance) {
            return false ;
        }
        this.balance = this.balance - amount;
        updateStatus();
        return true;
    }

    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        }
        this.balance = this.balance + amount;
        updateStatus();
        return true;
    }

    private void updateStatus() {
        this.accountStatus = 0;
        if (this.balance > 100_000) {
            this.accountStatus = 1;
        }
    }

    public String getAccountStatus() {
        if (this.accountStatus == 1) {
            return "Good";
        }
        return "Low";
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

}
