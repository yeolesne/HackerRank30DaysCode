/*
 * Objective:
Today we're discussing scope. Check out the Tutorial tab for learning materials and an instructional video!

The absolute difference between two integers, a and b, is written as |a-b|. The maximum absolute difference between two integers in a set of positive integers, elements, is the largest absolute difference between any two integers in elements.

The Difference class is started for you in the editor. It has a private integer array (elements) for storing N non-negative integers, and a public integer (maximumDifference) for storing the maximum absolute difference.

Task:

Complete the Difference class by writing the following:

1. A class constructor that takes an array of integers as a parameter and saves it to the elements instance variable.
2. A computeDifference method that finds the maximum absolute difference between any 2 numbers in N and stores it in the maximumDifference instance variable.

Input Format:

You are not responsible for reading any input from stdin. The locked Solution class in your editor reads in 2 lines of input; the first line contains N, and the second line describes the elements array.

Constraints:

1. 1 <= N <= 10
2. 1 <= elements[i] <= 100, where 0 <= i <= N-1
 
Output Format:

You are not responsible for printing any output; the Solution class will print the value of the maximumDifference instance variable.

Sample Input:

3
1 2 5

Sample Output:

4

Explanation:

The scope of the elements array and maximumDifference integer is the entire class instance. The class constructor saves the argument passed to the constructor as the elements instance variable (where the computeDifference method can access it).

To find the maximum difference, computeDifference checks each element in the array and finds the maximum difference between any 2 elements: |1-2| = 1


The maximum of these differences is 4, so it saves the value 4 as the maximumDifference instance variable. The locked stub code in the editor then prints the value stored as maximumDifference, which is 4.
 */

/*
 * Approach:  [The maximum absolute difference in the array will always be the absolute difference between the minimum and maximum element from the array]
 * Two methods "getmin(arr)" and "getMax(arr)" are written to get the minimum and maximum elements in the given array 
 * Then, the maximum absolute difference is calculated as: |minimum - maximum|
 */

package com.sjsu.edu.code.practice;

import java.util.*;

class Difference {
  	private int[] elements;
  	public int maximumDifference;

	// Add your code here
    public Difference(int[] arr){
        this.elements = arr; // Assigns the arr values to the elements array instance
    }

    public void computeDifference(){
        int max = getMax(elements); // Getting the maximum value in the "elements" array
        int min = getMin(elements); // Getting the minimum value in the "elements" array

        maximumDifference = Math.abs(min - max); // Computing the maximum absolute difference 
    }

    public int getMax(int[] array){ // Function to find maximum value in "elements" array
        int maxValue = array[0]; // Initialize the maxValue as array's first element
        for(int i = 1; i < array.length; i++){ // Traverse through the "elements" array starting from index 1
            if(array[i] > maxValue){ // If the element at ith index is greater than maxValue, then
                maxValue = array[i]; // assign the maxValue with value at array[i]
             }
        }
        return maxValue; // Return the maximum value
    }

    public int getMin(int[] array){ // Function to find minimum value in "elements" array
        int minValue = array[0]; // Initialize the minValue as array's first element
        for(int j = 1; j < array.length; j++){ // Traverse through the "elements" array starting from index 1
            if(array[j] < minValue){ // If the element at jth index is smaller than minValue, then
                minValue = array[j]; // assign the minValue with value at array[j]
            }
        }
        return minValue;  // Return the minimum value
    }

} // End of Difference class

public class Scope {

	//Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Reads the number of elements 'n' from user
        int[] a = new int[n]; // Create an array of integers with length 'n'
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt(); // Assign the elements to array's ith index
        }
        sc.close(); // Close the scanner object "sc"

        Difference difference = new Difference(a); // Invoke the Difference class constructor with array "a" as an argument

        difference.computeDifference(); // Call the computeDifference() method of Difference class

        System.out.print(difference.maximumDifference); // Prints the maximumDifference on console
    }
}