/*
 * Objective:
Today we're learning about running time! Check out the Tutorial tab for learning materials and an instructional video!

Task:

A prime is a natural number greater than 1 that has no positive divisors other than 1 and itself. Given a number, n, determine and print whether it's Prime or Not prime.

Note: If possible, try to come up with a O(sqrt(n)) primality algorithm, or see what sort of optimizations you come up with for an O(n) algorithm. Be sure to check out the Editorial after submitting your code!

Input Format:

The first line contains an integer, T, the number of test cases.
Each of the T subsequent lines contains an integer, n, to be tested for primality.

Constraints:

1. 1 <= T <= 30
2. 1 <= n <= 2 X 10^9

Output Format:

For each test case, print whether n is Prime or Not prime on a new line.

Sample Input:

3
12
5
7

Sample Output:

Not prime
Prime
Prime

Explanation:

Test Case 0: n = 12.
12 is divisible by numbers other than 1 and itself (i.e.: 2, 3, 6), so we print Not prime on a new line.

Test Case 1: n = 5.
5 is only divisible by 1 and itself, so we print Prime on a new line.

Test Case 2: n = 7.
7 is only divisible by 1 and itself, so we print Prime on a new line.

 */

package com.sjsu.edu.code.practice;

import java.util.*;

public class RunningTimeAndComplexity {
	
	//Function to check if a number is prime or not
	public static String primeNumber(int n){
        if(n == 1){ // Prime number is a natural number greater than 1
            return "Not prime"; // If n = 1, then number is not prime
        }

        for(int i = 2; i * i <= n; i++){ // For loop to check if a given number 'n' is divisible by numbers other than 1 and itself(n)
            if((n % i) == 0){ // If number 'n' is divisible by numbers other than 1 and itself(n)
                return "Not prime"; // return Not prime
            }
        }
        return "Prime"; // After checking the divisibility of a number 'n' for numbers other than 1 and itself(n),
        				//
    }

	//Main method to read input from the user
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        //Reads the number of test cases from user
        int T = sc.nextInt();

        //While loop to traverse through each test case
        while(T-- > 0){
            int num = sc.nextInt(); // Reads the number for each test cases from user 
            String isPrime = RunningTimeAndComplexity.primeNumber(num); // Calling the function with given number 'num' passed as an argument
            System.out.println(isPrime); // Prints if a number is Prime or Not prime
        }
        
        sc.close(); // Close the Scanner class object
    }

}
