/*
 * Objective:
Today, we're learning about Interfaces. Check out the Tutorial tab for learning materials and an instructional video!

Task:

The AdvancedArithmetic interface and the method declaration for the abstract divisorSum(n) method are provided for you in the editor below.

Complete the implementation of Calculator class, which implements the AdvancedArithmetic interface. The implementation for the divisorSum(n) method must return the sum of all divisors of n.

Input Format:

A single line containing an integer, n.

Constraints:

1 <= n <= 1000

Output Format:

You are not responsible for printing anything to stdout. The locked template code in the editor below will call your code and print the necessary output.

Sample Input:

6

Sample Output:

I implemented: AdvancedArithmetic
12

Explanation:

The integer 6 is evenly divisible by 1, 2, 3, and 6. Our divisorSum method should return the sum of these numbers, which is 1 + 2 + 3 + 6 = 12. The Solution class then prints I implemented: AdvancedArithmetic on the first line, followed by the sum returned by divisorSum (which is 12) on the second line.
 */

package com.sjsu.edu.code.practice;

import java.util.Scanner;

public class InterfacesChallenge implements AdvancedArithmetic{

	@Override
	public int divisorSum(int n) { // Implementation of abstract method
		// TODO Auto-generated method stub\
		int sum = 0; // Initialize the sum to 0
        for(int i = 1; i <= n; i++){ // for loop to traverse through the divisors (factors) of a given number 'n'. Divisors will always start from 1 to the number 'n'
            if((n % i) == 0){ // If 'i', a number divides the integer 'n' completely, that is -> remainder is 0..
                sum = sum + i; // Then 'i' is a divisor (factor) and we add the number 'i' to sum, calculate sum af all divisors
            }
        }
        return sum; // Return the calculated sum
	}

}

class implement {

	//Main method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Creates object of Scanner class
        int n = scan.nextInt(); // Reads the number as input from user
        scan.close(); // Close the Scanner object
        
      	AdvancedArithmetic myCalculator = new InterfacesChallenge();  // Create a reference of type interface "AdvancedArithmetic" to hold the object of child class "InterfacesChallenge"
        int sum = myCalculator.divisorSum(n); // Calling the child class method "divisorSum(int n)" that returns the sum of all divisors
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() ); // Print name of Interface on console
        System.out.println(sum); // Print the sum of all divisors on console
    }
}
