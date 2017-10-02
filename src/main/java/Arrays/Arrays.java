package Arrays;

import java.util.Scanner;

public class Arrays {
    // Arrays

    public static void getArray(int[] arr) {
        for (int temp : arr) {
            System.out.print(temp + "  ");
        }
        System.out.println();
    }

    public static int[] setArray(final int SIZE) {
        if (SIZE <= 0) {
            return null;
        }
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = scan.nextInt();
        }
        return arr;
    }

    public static double sumElemArray(int[] arr) {
        double temp = 0;
        for (int i : arr) {
            temp += i;
        }
        return temp / arr.length;
    }

    public static int amountChetnNumbers(int[] arr) {
        int amount = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                amount++;
            }
        }
        return amount;
    }

    public static int amountNumbersIncludeAB(int[] arr, double a, double b) {

        int amount = 0;
        double temp = 0;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        for (int i : arr) {
            if (i >= a && i <= b) {
                amount++;
            }
        }
        return amount;
    }

    public static boolean posNumbers(int[] arr) {
        for (int i : arr) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    public static void reverseArray(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}
