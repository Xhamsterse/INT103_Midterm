/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavaarray;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Khaitong Lim
 */
public class RefAndPrimitiveVariable {

    public static void main(String args[]) {
        int x = 10;
        int y = 20;
        Random r = new Random();
        r.setSeed(13254896574582L);
        double a = r.nextDouble();
        String s = new String("SIT: School of information Technology");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 integer number seperate with space: ");
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        int v3 = sc.nextInt();
        System.out.println(findMax(9, 70));
    }

    private static int findMax(int x, int y) {
        System.out.println("findMax(int x, int y)");
        return otherFindMax(y, x);
    }

    private static int otherFindMax(int x, int y) {
        System.out.println("otherFindMax(int x, int y)");
        return Math.max(x, y);
    }
}
