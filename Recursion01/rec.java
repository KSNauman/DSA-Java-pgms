package Recursion01;

public class rec {
    public static void printInc(int n) {
        if (n == 1) {
            // System.out.println(n + " ");
            System.out.println(n + "  ");
            return;
        }
        printInc(n - 1);
        System.out.println(n + "  ");
    }

    public static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int firstOccurence(int[] arr, int key, int i) {
        if (i > arr.length - 1) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, key, i + 1);
    }

    public static int lastOccurance(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurance(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
        /* for clear understanding of recursive just practice the stack call table */
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);
    }

    public static int powerOptimized(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int half = power(x, n / 2);
        /*
         * int half = power(x, n/2) * power(x, n/2);
         * will be same linear time complexity
         */
        int halfpo = half * half;
        if (n % 2 != 0) {
            halfpo = x * halfpo;
        }
        return halfpo;
    }

    public static void main(String[] args) {
        // printInc(5);
        int[] arr = { 1, 2, 3, 3, 4 };
        // System.out.println(isSorted(arr, 0));
        // System.out.println(firstOccurence(arr, 5, 0));
        // System.out.println(lastOccurance(arr, 3, 0));
        System.out.println(powerOptimized(2, 5));
    }
}
