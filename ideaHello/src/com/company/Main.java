package com.company;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = s.nextInt();
        }
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
