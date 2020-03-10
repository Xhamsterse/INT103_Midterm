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
public class TestTwoDimensionArray {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4] ;
        System.out.println(matrix.length);
        
        System.out.println(matrix[0].length);
        System.out.println(matrix[1].length);
        System.out.println(matrix[2].length);
        String[][] str = new String[5] [];
        str[0] = new String[5]; // str[0][0] - str[0][4] ;
        str[1] = new String[17]; // str[0][0] - str[0][16] ;
        str[1][15] ="ABCD" ;
//        str[0][15] ="XYZ" ;
        System.out.println(str.length);
        BankAccount[][] bas = new BankAccount[5][] ;
        bas[0] = new BankAccount[3];
        bas[1] = new BankAccount[5];
        bas[2] = new BankAccount[1];
        bas[3] = new BankAccount[10];
        bas[4] = new BankAccount[100];
        
        bas[0][0] = new BankAccount(10001, "1A", 500) ;
        bas[0][1] = new BankAccount(10002, "2A", 500) ;
        bas[0][2] = new BankAccount(10003, "3A", 500) ;
        
        bas[4][0] = new BankAccount(50001, "5A", 5500) ;
        bas[4][99] = new BankAccount(50099, "5ZZ", 9000) ;
        
        for (int i = 0; i < bas.length; i++) {
            for (int j = 0; j < bas[i].length; j++) {
                if (bas[i][j] != null) {
                    System.out.println(bas[i][j].getAccountNumber()  + ": "+ bas[i][j].getName());
                }
            }
            System.out.println("------------------");
            
        }
    }
    
}
 