package com.xuexi.sonya;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TwoOneDimensional {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size1 = sc.nextInt();
        int size2 = sc.nextInt();

        sc.close();

        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];

        //initializing arrays
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) ((Math.random() + 1) * 10);
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) ((Math.random() + 1) * 10);
        }

        int[] result;
        if (arr1.length == arr2.length) {
            result = new int[arr1.length];

            for (int i = 0; i < arr1.length; i++) {
                result[i] = arr1[i] + arr2[i];
            }
        } else {
            int difference = Math.abs(arr1.length - arr2.length);
            result = new int[difference];
            int[] biggerArr;
            int[] smallerArr;

            if (arr1.length > arr2.length) {
                biggerArr = arr1;
                smallerArr = arr2;
            } else {
                biggerArr = arr2;
                smallerArr = arr1;
            }

            for (int i = smallerArr.length, k = 0; i < biggerArr.length; i++) {
                result[k++] = biggerArr[i];
            }
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(result));
    }
}
