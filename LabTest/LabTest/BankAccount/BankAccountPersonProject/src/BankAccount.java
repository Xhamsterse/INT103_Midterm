/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umaporn
 */
public class BankAccount {
    private long accountId;
    private Person[] accountOwners;
    private double balance;
    private int accountNameCounting;
    
    public BankAccount(Person firstPerson, int numberOfAccountName, double balance){
    
        this.accountId=firstPerson.getIdCard();
        if(numberOfAccountName>5)
            this.accountOwners=new Person[5];
        else
            this.accountOwners=new Person[numberOfAccountName];
        this.accountOwners[accountNameCounting++]=firstPerson;
        this.balance=balance;
    }

    public boolean addAccountName(long idCard, String newFirstName, String newLastName){
        if(accountNameCounting>=accountOwners.length)
            return false;
        accountOwners[accountNameCounting++]=new Person(idCard, newFirstName, newLastName);
        return true;
    }

    public long getAccountId() {
        return accountId;
    }

    public Person[] getAccountName(){
        Person temp[]=new Person[accountNameCounting];
        for(int index=0;index<accountNameCounting;index++){
            temp[index]=accountOwners[index];
        }
        return temp;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public boolean withdraw(double amount){
        if(amount<=0 || amount>balance)
            return false;
        balance-=amount;
        return true;
    }
    public boolean deposit(double amount){
        if(amount<=0)
            return false;
        balance+=amount;
        return true;
    }
    public boolean transfer(BankAccount targetAccount, double amount){
        if(amount<=0 || amount>balance)
            return false;
        withdraw(amount);
        targetAccount.deposit(amount);
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder accountString= new StringBuilder(accountId + "\n");
        for(int index=0;index<accountNameCounting;index++){
            accountString.append(accountOwners[index]+"\n");
            
        }
        accountString.append("balance=" + balance+"\n");
      
        return accountString.toString();
    }
    

    
}

