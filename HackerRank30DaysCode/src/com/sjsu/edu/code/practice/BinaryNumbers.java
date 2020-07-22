/*
 * Objective:
Today, we're working with binary numbers. Check out the Tutorial tab for learning materials and an instructional video!

Task:
Given a base-10 integer, n, convert it to binary (base-2).Then find and print the base-10 integer denoting the maximum number of consecutive 1's in n's binary representation.

Input Format:

A single integer, n.

Constraints:
1 <= n <= 10^6

Output Format:

Print a single base-10 integer denoting the maximum number of consecutive 1's in the binary representation of n.

Sample Input 1:
5

Sample Output 1:
1

Sample Input 2:
13

Sample Output 2:
2

Explanation:

Sample Case 1:
The binary representation of 5 is 101, so the maximum number of consecutive 1's is 1.

Sample Case 2:
The binary representation of 13 is 1101, so the maximum number of consecutive 1's is 2.
 */

package com.sjsu.edu.code.practice;

public class BinaryNumbers {
	
	int counter = 0;
	
	public int consecutiveOnes(int n) {
		String binaryNumber = Integer.toBinaryString(n);
		System.out.println(binaryNumber);
		
		for(String str: binaryNumber.split("0")) { //The method split() splits a String into multiple Strings given the delimiter that separates them.
			counter = str.length() > counter ? str.length() : counter;		
		}
		return counter;
		
	}
	
	public static void main(String[] args) {
		BinaryNumbers bn = new BinaryNumbers();
		int n = 7;
		int result = bn.consecutiveOnes(n);
		System.out.println(result);
	}

}
