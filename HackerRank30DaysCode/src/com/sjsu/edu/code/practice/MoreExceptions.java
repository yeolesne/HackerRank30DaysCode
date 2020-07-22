/*
 * Objective:
Yesterday's challenge taught you to manage exceptional situations by using try and catch blocks. In today's challenge, you're going to practice throwing and propagating an exception. Check out the Tutorial tab for learning materials and an instructional video!

Task:

Write a Calculator class with a single method: int power(int,int). The power method takes two integers, n and p, as parameters and returns the integer result of n^p. If either n or p is negative, then the method must throw an exception with the message: n and p should be non-negative.

Note: Do not use an access modifier (e.g.: public) in the declaration for your Calculator class.

Input Format:

Input from stdin is handled for you by the locked stub code in your editor. The first line contains an integer, T, the number of test cases. Each of the T subsequent lines describes a test case in 2 space-separated integers denoting n and p, respectively.

Constraints:

No Test Case will result in overflow for correctly written code.

Output Format:

Output to stdout is handled for you by the locked stub code in your editor. There are T lines of output, where each line contains the result of n^p as calculated by your Calculator class' power method.

Sample Input:

4
3 5
2 4
-1 -2
-1 3

Sample Output:

243
16
n and p should be non-negative
n and p should be non-negative

Explanation:

T = 4
T0: 3 and 5 are positive, so power returns the result of 3^5, which is 243.
T1: 2 and 4 are positive, so power returns the result of 2^4=, which is 16.
T2: Both inputs (-1 and -2) are negative, so power throws an exception and "n and p should be non-negative" is printed.
T3: One of the inputs (-1) is negative, so power throws an exception and "n and p should be non-negative" is printed.
 
 *Image: Desktop/Ecxeption_Hierarchy.png
 */

package com.sjsu.edu.code.practice;

import java.util.*;

//Write your code here
class Calculator{
    public int power(int n, int p) throws Exception{ // Method needs to have "throws Exception" declared in class definition to pass all test cases
        int result = 0; // Initialize the result to 0
        if(n >= 0 && p >= 0){ // Check if n and p are non-negative
        	// If yes, then calculate the result of n^p
            result = (int)(Math.pow(n, p)); // Convert the result of type double to int
        }else{
            throw new Exception("n and p should be non-negative"); // If any of the given numbers is negative, thn throw the exception with given message 
        }
    return result; // Return the result
    }
}

public class MoreExceptions{

	//Main method
    public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in); // Create object of Scanner class
        int t = in.nextInt(); // Reads number of test cases from user
        while (t-- > 0) { // While test cases number greater than 0
        
            int n = in.nextInt(); // Reads n for each test case
            int p = in.nextInt(); // Reads p for each test case
            Calculator myCalculator = new Calculator(); // Create object of "Calculator" class
            try { // Execute the code
                int ans = myCalculator.power(n, p); // Call the power method of Calculator class that returns the result of n^p
                System.out.println(ans); // Print the result for each test case
            }
            catch (Exception e) { // Handle the Exception thrown by the called method (power)
                System.out.println(e.getMessage()); // Print the Exception message on console
            }
        }
        in.close(); // Close the Scanner class object
    }
}

