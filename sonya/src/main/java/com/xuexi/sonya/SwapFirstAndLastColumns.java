package com.xuexi.sonya;

import java.util.Scanner;

public class SwapFirstAndLastColumns {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        sc.close();

        int[][] arr = new int[size][size];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = (int) ((Math.random() + 1) * 10);
            }
        }

        int[][] result = new int[size][size];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i][j] = arr[i][j];
            }
        }

        /**
         * 1 2 1 temp = 3
         * 4 5 6
         * 7 8 9
         */
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (j == 0) {
                    int temp = result[i][result.length - 1];
                    result[i][result.length - 1] = result[i][j];
                    result[i][j] = temp;
                }
            }
        }

        print2DArray(arr);
        System.out.println();
        print2DArray(result);
    }

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
