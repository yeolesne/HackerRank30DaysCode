/*
 * Objective:
Today, we're building on our knowledge of Arrays by adding another dimension. Check out the Tutorial tab for learning materials and an instructional video!

Context:
Given a 6x6 2D Array, A:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

We define an hourglass in A to be a subset of values with indices falling in this pattern in A's graphical representation:

a b c
  d
e f g

There are 16 hourglasses in A, and an hourglass sum is the sum of an hourglass' values.

Task:

Calculate the hourglass sum for every hourglass in A, then print the maximum hourglass sum.

Input Format:

There are 6 lines of input, where each line contains 6 space-separated integers describing 2D Array A; every value in A will be in the inclusive range of -9 to 9.

Constraints:

-9 <= A[i][j] <= 9
0 <= i, j <= 5

Output Format:

Print the largest (maximum) hourglass sum found in A.

Sample Input:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

Sample Output:

19

Explanation:

A contains the following hourglasses:

1 1 1   1 1 0   1 0 0   0 0 0
  1       0       0       0
1 1 1   1 1 0   1 0 0   0 0 0

0 1 0   1 0 0   0 0 0   0 0 0
  1       1       0       0
0 0 2   0 2 4   2 4 4   4 4 0

1 1 1   1 1 0   1 0 0   0 0 0
  0       2       4       4
0 0 0   0 0 2   0 2 0   2 0 0

0 0 2   0 2 4   2 4 4   4 4 0
  0       0       2       0
0 0 1   0 1 2   1 2 4   2 4 0
The hourglass with the maximum sum(19) is:

2 4 4
  2
1 2 4

 */

package com.sjsu.edu.code.practice;

import java.util.*;

public class TwoDimensionalArrays {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        int maxSum = Integer.MIN_VALUE; //Assigns minimum value to the 'maxSum' variable

        for(int i = 0; i < 6; i++){ // for loop to traverse through the rows in A
            for(int j = 0; j < 6; j++){ // for loop to traverse through the columns in A
                arr[i][j] = scanner.nextInt(); // First fill the first two rows completely and three elements of 3rd row to get our 1st hourglass in 2D array
                								// 'j' for loop keep running until the row is filled, and after every jth element is filled, we get another hourglass
                								// After all the columns of particular row is filled, 'i' increments and like before, first 3 elements of that new row are filled to get an other hourglass
                								// The process is repeated until all the rows and columns are traversed and filled....

                if(i > 1 && j > 1){ // Once we get first hourglass, where i and j should be atleast 2
                    int sum =                // calculate the sum of elements at respective indices
                        arr[i][j] 
                        + arr[i][j-1]
                        + arr[i][j-2]
                        + arr[i-1][j-1]
                        + arr[i-2][j]
                        + arr[i-2][j-1]
                        + arr[i-2][j-2];

                    if(sum > maxSum){ // If calculated sum is greater than assigned value of maxSum,
                        maxSum = sum; // then, assign the greater value (sum) to 'maxSum' variable
                    }
                }
            }

        }

        System.out.println(maxSum); // Print the max sum of hourglass in A

        scanner.close(); // Close the scanner object
    }
}


