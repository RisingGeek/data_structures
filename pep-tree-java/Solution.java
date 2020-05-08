import java.io.*;
import java.util.*;

class Solution {

    static int[] absSort(int[] arr) {
        // your code goes here
        Integer[] newArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        Arrays.sort(newArr, (Integer a, Integer b) -> {
            if (Math.abs(a) == Math.abs(b))
                return a - b;
            return Math.abs(a) - Math.abs(b);
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 2, -7, -2, -2, 0 };
        absSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
