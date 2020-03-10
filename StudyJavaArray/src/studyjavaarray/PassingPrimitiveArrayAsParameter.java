/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavaarray;

import java.util.Random;

/**
 *
 * @author Khaitong Lim
 */
public class PassingPrimitiveArrayAsParameter {

    private static int MAX_SIZE = 5;
    private static int ITEM_PER_LINE = 15;

    private final static Random random = new Random();

    public static void main(String[] args) {
        int x[] = new int[MAX_SIZE];
        init(x);
        printArray(x);
        int[] maxMin = findMinMax(x);
        System.out.println("--------------------------");
        System.out.printf("Min = %3d@[%d]\nMax = %3d@[%d]\n", x[maxMin[0]], maxMin[0], x[maxMin[1]],maxMin[1]);
    }

    private static void init(int[] param) {
        param[0] = 9;
        for (int i = 1; i < param.length; i++) {
            param[i] = random.nextInt(1000);
        }
    }

    private static void printArray(int[] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            int item = tmp[i];
            System.out.printf("%-3s     %s",
                    (item < 10 ? "00" : item < 100 ? "0" : "") + item,
                    ((i + 1) % ITEM_PER_LINE == 0 ? "\n" : ""));
        }
        System.out.println("");
    }

    private static int[] findMinMax(int[] param) {
        int result[] = new int[2];
        int maxPos = 0;
        int minPos = param.length - 1;

        for (int i = 0; i < param.length; i++) {
            if (i > 0 && param[i] > param[maxPos]) {
                maxPos = i;
            }
            if (i > 0 && param[param.length - i - 1] < param[minPos]) {
                minPos = param.length - i - 1;
            }
        }
        result[0] = minPos;
        result[1] = maxPos;
        return result;
    }
}
