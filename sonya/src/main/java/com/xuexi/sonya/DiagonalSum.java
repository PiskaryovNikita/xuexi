package com.xuexi.sonya;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class DiagonalSum {

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

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    sum += arr[i][j];
                }
            }
        }

        print2DArray(arr);
        System.out.println(sum);
    }

    public static void print2DArray(int [][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
