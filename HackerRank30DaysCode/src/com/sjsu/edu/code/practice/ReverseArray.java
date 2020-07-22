/*
 * Objective:
Today, we're learning about the Array data structure. Check out the Tutorial tab for learning materials and an instructional video!

Task:
Given an array, A, of N integers, print A's elements in reverse order as a single line of space-separated numbers.

Input Format:

The first line contains an integer, N (the size of our array).
The second line contains N space-separated integers describing array A's elements.

Constraints:

1 <= N <= 1000
1 <= Ai <= 10000, where Ai is the ith integer in the array.

Output Format:

Print the elements of array A in reverse order as a single line of space-separated numbers.

Sample Input:

4
1 4 3 2

Sample Output:

2 3 4 1
 */

package com.sjsu.edu.code.practice;

import java.util.Scanner;

public class ReverseArray {

    public static void reverseArray(int n, int[] arr){
        for(int j = n-1; j >= 0; j--){
            System.out.print(arr[j] + " ");
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        ReverseArray.reverseArray(n, arr);

        scanner.close();
    }
}
