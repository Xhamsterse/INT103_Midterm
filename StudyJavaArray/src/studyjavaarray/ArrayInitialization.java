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
public class ArrayInitialization {
    public static void main(String[] args) {
        int size = 16 ;
        int numbers[] = new int[size<<1];
        
        boolean b1[], b2[], b3 ;
        
        b1 = new boolean[size*2];
        b2 = new boolean[size>>1];
        
        String[] strings = new String[size];
        BankAccount[]  ba1, ba2 ;
        ba1 = new BankAccount[size];
        ba2 = new BankAccount[size*3/2+1];
        numbers[numbers.length<<1] = 50 ;
        b1[3] = true ;
        ba1[0] = new BankAccount(10001, "Somchai", 5_200.50);
        ba1[3] = new BankAccount(30009, "Anuchart", 30_000);
        ba1[7] = new BankAccount(30009, "Surapong", 70_000.25);
        
        BankAccount[] ba3 = {new BankAccount(9009, "A", 100), ba1[0], 
            new BankAccount(), new BankAccount(700014, "B", 500)} ;
        
        ba3[1].deposit(980_000);
    }
    
}
