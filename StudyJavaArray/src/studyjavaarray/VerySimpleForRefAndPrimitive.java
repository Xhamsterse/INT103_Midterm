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
public class VerySimpleForRefAndPrimitive {
   public static void main(String args[]) {
      int x, y ;
      BankAccount ba1, ba2, ba3 ;
      x = 5 ;
      y = 100 ;
      ba1 = new BankAccount(90001, "Somchai", 900);
      ba2 = new BankAccount(90009, "Somsri", 12000);  
      ba3 = ba1 ;
      ba2.deposit(190_000);
      ba1.deposit(90_000);    
       System.out.println(ba3.withdraw(50_000));
   }
}