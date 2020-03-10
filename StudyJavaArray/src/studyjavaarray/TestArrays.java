/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavaarray;

/**
 *
 * @author int101
 */
public class TestArrays {

    public static void main(String[] args) {
//        String x = "ant" ;
//        String y = "cat" ;
//        String z = "ant" ;
//        System.out.println(x.compareTo(y));
//        System.out.println(y.compareTo(x));
//        System.out.println(x.compareTo(z));
        BankAccount ba = new BankAccount(1001, "A", 9500.10);
        BankAccount bb = new BankAccount(1001, "A", 9500.00);
        BankAccount bc = new BankAccount(1001, "A", 9500.10);
        int cmp = ba.compareTo(bb) ;
        if (cmp>0) {
            System.out.println("ba richer than bb");
        } else if(cmp<0) {
            System.out.println("bb richer than ba");
        } else {
            System.out.println("balance of ba  ==  balance of bb");
        }
        System.out.println(bb.compareTo(ba));
        System.out.println(ba.compareTo(bc));
    }

}
