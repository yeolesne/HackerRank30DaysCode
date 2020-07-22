/*
 * Objective:
Today, we're discussing a simple sorting algorithm called Bubble Sort. Check out the Tutorial tab for learning materials and an instructional video!

Consider the following version of Bubble Sort:

for (int i = 0; i < n; i++) {
    // Track number of elements swapped during a single array traversal
    int numberOfSwaps = 0;
    
    for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
            swap(a[j], a[j + 1]);
            numberOfSwaps++;
        }
    }
    
    // If no elements were swapped during a traversal, array is sorted
    if (numberOfSwaps == 0) {
        break;
    }
}

Task:

Given an array, a, of size n distinct elements, sort the array in ascending order using the Bubble Sort algorithm above. Once sorted, print the following 3 lines:

1. Array is sorted in numSwaps swaps.
   where numSwaps is the number of swaps that took place.
2. First Element: firstElement
   where firstElement is the first element in the sorted array.
3. Last Element: lastElement
   where lastElement is the last element in the sorted array.
   
Hint: To complete this challenge, you will need to add a variable that keeps a running tally of all swaps that occur during execution.

Input Format:

The first line contains an integer, n, denoting the number of elements in array a.
The second line contains n space-separated integers describing the respective values of a0, a1, ...., an-1.

Constraints:

1. 2 <= n <= 600
2. 1 <= ai <= 2x10^6, where 0 <= i < n.

Output Format:

Print the following three lines of output:

1. Array is sorted in numSwaps swaps.
   where numSwaps is the number of swaps that took place.
2. First Element: firstElement
   where firstElement is the first element in the sorted array.
3. Last Element: lastElement
   where lastElement is the last element in the sorted array.

Sample Input 0:

3
1 2 3

Sample Output 0:

Array is sorted in 0 swaps.
First Element: 1
Last Element: 3

Explanation 0:

The array is already sorted, so 0 swaps take place and we print the necessary 3 lines of output shown above.

Sample Input 1:

3
3 2 1

Sample Output 1:

Array is sorted in 3 swaps.
First Element: 1
Last Element: 3

Explanation 1:

The array a = [3,2,1] is not sorted, so we perform the following 3 swaps:

1. [3,2,1] -> [2,3,1]
2. [2,3,1] -> [2,1,3]
3. [2,1,3] -> [1,2,3]

At this point the array is sorted and we print the necessary 3 lines of output shown above.
 */

package com.sjsu.edu.code.practice;

import java.util.*;

public class Sorting {

    public static int[] bubbleSort(int[] arr, int n){
        int numSwaps = 0; // Initialize "numSwaps" to 0, tracks the number of elements swapped during a single array traversal (one complete traversal of inner for loop)
        for(int i = 0; i < n; i++){ // for loop to keep track of number of passes in bubble sorting
            for(int j = 0; j < n-1; j++){ // Inner for loop to traverse the complete array in each pass
                if(arr[j] > arr[j+1]){ // If element at jth index is greater than (j+1)th index then we need to swap them for sorting in ascending order
                    int tmp = arr[j];
                    arr[j] = arr[j+1];  // Code to swap the adjacent elements
                    arr[j+1] = tmp;
                    numSwaps++; // Increment the number of swaps in each pass
                }
            }
        }
        System.out.println("Array is sorted in " + numSwaps + " swaps."); // Print the total number of swaps on console
        return arr; // Return the Sorted array

    }

    //Main method
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Creating the Scanner class object
        int n = in.nextInt(); // Reads the number of elements from user
        int[] a = new int[n]; // Create an array of length 'n'
        for(int a_i=0; a_i < n; a_i++){ // Traverse through the newly created array
            a[a_i] = in.nextInt(); // Assign each element to the array 'a'
        }
        // Write Your Code Here
        int[] array = Sorting.bubbleSort(a, n); // Calling the method "bubbleSort" with an array and length of array as passed arguments that returns the sorted array
        System.out.println("First Element: " + array[0]); // Prints the first element of sorted array
        System.out.println("Last Element: " + array[n-1]); // Prints the last element of sorted array
        
        in.close(); // Close the Scanner class object

    }
}