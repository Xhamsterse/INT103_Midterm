/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umaporn
 */
public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount sudaBA=new BankAccount(new Person(3100001187911L, "Suda", "Jaidee"), 2, 1500);
        sudaBA.addAccountName(1234567891234L, "Somchai", "Jaidee");
        BankAccount suchaiBA=new BankAccount(new Person(3100001187912L, "SuChai", "Pobdee"), 1, 1000);
        System.out.println("Suda deposit:"+sudaBA.deposit(100));
        System.out.println(sudaBA);
        System.out.println("Suchai deposit:"+suchaiBA.deposit(500));
        System.out.println(suchaiBA);
        System.out.println("Suda withdraw:"+sudaBA.withdraw(10));
        System.out.println("Suchai withdraw:"+suchaiBA.withdraw(100));
        System.out.println(sudaBA);
        System.out.println(suchaiBA);
        System.out.println(suchaiBA.addAccountName(1212121212121L, "Supot", "Lee"));
        sudaBA.transfer(suchaiBA, 500);
        System.out.println(sudaBA);
        System.out.println(suchaiBA);
    }
}
