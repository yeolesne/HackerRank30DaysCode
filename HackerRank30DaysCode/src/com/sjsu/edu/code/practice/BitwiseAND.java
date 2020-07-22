/*
 * Objective:
Welcome to the last day! Today, we're discussing bitwise operations. Check out the Tutorial tab for learning materials and an instructional video!

Task:

Given set S = {1,2,3,..,N}. Find two integers, A and B (where A<B), from set S such that the value of A&B is the maximum possible and also less than a given integer, K. In this case, & represents the bitwise AND operator.

Input Format:

The first line contains an integer, T, the number of test cases.
Each of the T subsequent lines defines a test case as 2 space-separated integers, N and K, respectively.

Constraints:

1. 1 <= T <= 10^3
2. 2 <= N <= 10^3
3. 2 <= K <= N

Output Format:

For each test case, print the maximum possible value of A&B on a new line.

Sample Input:

3
5 2
8 5
2 2

Sample Output:

1
4
0

Explanation:

N = 5, K = 2, S = {1,2,3,4,5}

All possible values of A and B are:

1. A = 1, B = 2; A & B = 0
2. A = 1, B = 3; A & B = 1
3. A = 1, B = 4; A & B = 0
4. A = 1, B = 5; A & B = 1
5. A = 2, B = 3; A & B = 2
6. A = 2, B = 4; A & B = 0
7. A = 2, B = 5; A & B = 0
8. A = 3, B = 4; A & B = 0
9. A = 3, B = 5; A & B = 1
10. A = 4, B = 5; A & B = 4

The maximum possible value of A & B that is also <(K = 2) is 1, so we print 1 on a new line.

Steps:

1. Create a set with 'N' elements starting from 1 to N
2. Convert Set into a List
3. Add elements from 1 to N to a List
4. Initialize the 'max' variable to 0
5. Outer for loop starting at 0th index and ending at < N-1
6. Inner for loop starting at i+1th index and ending at <= N-1
7. Inside inner for loop, check if A < B, if yes calculate A&B
8. Inside If condition in inner for loop, Check if A & B result is > max variable value and < value of K
9. If yes, then only assign the result value to max variable
10. Prints the maximum possible value of A & B on a new line for each test case, outside the outer for loop and inside the test case for loop	

 */

package com.sjsu.edu.code.practice;

import java.util.*;

public class BitwiseAND {

	// Create Scanner class object
	private static final Scanner scanner = new Scanner(System.in);

	// Main method
    public static void main(String[] args) {
    	
    	// Read number of test cases from user
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // for each test case
        for (int tItr = 0; tItr < t; tItr++) {
        	// Read the 2 space separated integers in a String array
            String[] nk = scanner.nextLine().split(" ");

            // Convert the String elements to integer and store in respective variables
            int n = Integer.parseInt(nk[0]); // Total elements in set

            int k = Integer.parseInt(nk[1]); // max value of A & B should be less than K

  /***************************************************************************/
            // Create a set with 'N' elements starting from 1 to N
            Set<Integer> a = new HashSet<Integer>(n);
            
            // Convert the Set into a List
            List<Integer> list = new ArrayList<Integer>(a);
    
            // Add elements from 1 to N in the List
            for(int i = 1; i <= n; i++) {
                list.add(i);
            }

 /****************************************************************************/
            int max = 0; // initialize the maximum value variable to 0
            
            // Outer for loop starting at 0th index and ending at < N-1
            for(int j = 0; j < n-1; j++){
            	
                // Inner for loop starting at i+1 th index and ending at <= N-1
                for(int l = j+1; l <= n-1; l++){
                	// If A < B
                    if(list.get(j) < list.get(l)){
                    	// Calculate A & B
                        int result = list.get(j) & list.get(l);

                        // Check if A & B result is > max variable value and < value of K
                        if((result > max) && (result < k)){
                            max = result; // If yes, then only assign the result value to max variable
                        }

                    }
                }
            }
            System.out.println(max); // Prints the maximum possible value of A & B on a new line for each test case

        }
/*****************************************************************************/
        
        scanner.close(); // Close the Scanner class object
    }

}
	

