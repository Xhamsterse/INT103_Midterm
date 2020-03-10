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
public class HashCodeAndObjectAddress {

    public static void main(String[] args) {
        int x = 5 ;
         int y = 100 ;
         BankAccount ba1 = new BankAccount(90001, "Somchai", 900);
         BankAccount ba2 = new BankAccount(90009, "Somsri", 12000);  
         BankAccount ba3 = ba1 ;

        System.out.println("ba1 ->" + ba1);
        System.out.println("ba2 ->" + ba2);
        System.out.println("ba3 ->" + ba3);
        System.out.println("ba1 hashCode: " + Long.toHexString(ba1.hashCode()));
        System.out.println("ba2 hashCode: " + Long.toHexString(ba2.hashCode()));
        System.out.println("ba3 hashCode: " + Long.toHexString(ba3.hashCode()));
        
        int xArr[] = {1, 2, 3, 4, 5, 6};
        System.out.println("xArr -> " + xArr);
        System.out.println("xArr hashCode: " + Long.toHexString(xArr.hashCode()));

    }

}
