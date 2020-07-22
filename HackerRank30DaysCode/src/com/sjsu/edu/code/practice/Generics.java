/*
 * Objective:
Today we're discussing Generics; be aware that not all languages support this construct, so fewer languages are enabled for this challenge. Check out the Tutorial tab for learning materials and an instructional video!

Task:

Write a single generic function named printArray; this function must take an array of generic elements as a parameter (the exception to this is C++, which takes a vector). The locked Solution class in your editor tests your function.

Note: You must use generics to solve this challenge. Do not write overloaded functions.

Input Format:

The locked Solution class in your editor will pass different types of arrays to your printArray function.

Constraints:

You must have exactly 1 function named printArray.

Output Format:

Your printArray function should print each element of its generic array parameter on a new line.

The letters enclosed between angle brackets (< and >) are type parameters and, like many things in programming, there is a convention behind them (remember, following conventions help us write clean, readable code!). The letters below are commonly-used generic type parameters:

E - Element
K - Key
V - Value
N - Number
T - Type (e.g.: data type)
S,U,V, etc. These are second, third, and fourth types for when T is already in use.
 */

package com.sjsu.edu.code.practice;

import java.util.*;

class Printer <T> {

    /**
    *    Method Name: printArray
    *    Print each element of the generic array on a new line. Do not return anything.
    *    @param A generic array
    **/
    
    // Write your code here
    public <E> void printArray(E[] inputArray){ // Generic array as a parameter passed to a function "printArray" (Array could be of type Integer or String for instance)
        for(E element : inputArray){ // Traverse through the elements of a generic array
            System.out.println(element); // Prints each element on a new line
        }

    }

}

public class Generics {
    
	//Main method
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of elements
        Integer[] intArray = new Integer[n];
        for (int i = 0; i < n; i++) { // Creating Integer array
            intArray[i] = scanner.nextInt();
        }

        n = scanner.nextInt(); // number of elements
        String[] stringArray = new String[n];
        for (int i = 0; i < n; i++) { // Creating String array
            stringArray[i] = scanner.next();
        }
        
        Printer<Integer> intPrinter = new Printer<Integer>(); // Creating object of parameter type Integer
        Printer<String> stringPrinter = new Printer<String>(); // Creating object of parameter type String
        intPrinter.printArray( intArray  ); // Calling printArray function with Integer type object
        stringPrinter.printArray( stringArray ); // Calling printArray function with String type object
        if(Printer.class.getDeclaredMethods().length > 1){ // If Printer class has more than one print method, then print the following statement on console
            System.out.println("The Printer class should only have 1 method named printArray.");
        }
        
        scanner.close(); // Close the Scanner class object
    } 
}
