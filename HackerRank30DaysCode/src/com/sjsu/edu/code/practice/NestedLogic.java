/*
 * Objective:
Today's challenge puts your understanding of nested conditional statements to the test. You already have the knowledge to complete this challenge, but check out the Tutorial tab for a video on testing!

Task:

Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:

1. If the book is returned on or before the expected return date, no fine will be charged (i.e.: fine = 0).
2. If the book is returned after the expected return day but still within the same calendar month and year as the expected return date, fine = 15 Hackos x (the number of days late).
3. If the book is returned after the expected return month but still within the same calendar year as the expected return date, the fine = 500 Hackos x (the number of months late).
4. If the book is returned after the calendar year in which it was expected, there is a fixed fine of 10000 Hackos.

Input Format:

The first line contains 3 space-separated integers denoting the respective day, month, and year on which the book was actually returned.
The second line contains 3 space-separated integers denoting the respective day, month, and year on which the book was expected to be returned (due date).

Constraints:

1. 1 <= D <= 31
2. 1 <= M <= 12
3. 1 <= Y <= 3000
4. It is guaranteed that the dates will be valid Gregorian calendar dates.

Output Format:

Print a single integer denoting the library fine for the book received as input.

Sample Input:

9 6 2015
6 6 2015

Sample Output:

45

Explanation:

Given the following return dates:
Actual: Da = 9, Ma = 6, Ya = 2015
Expected: De = 6, Me = 6, Ye = 2015

Because Ye == Ya, we know it is less than a year late.
Because Me == Ma, we know it's less than a month late.
Because De < Da, we know that it was returned late (but still within the same month and year).

Per the library's fee structure, we know that our fine will be 15 Hackos X (# days late). We then print the result of 15 X (Da - De) = 15 X (9 - 6) = 45 as our output.
 */

package com.sjsu.edu.code.practice;

import java.util.Scanner;

public class NestedLogic {
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

		 	// Create a Scanner class object
	        Scanner scan = new Scanner(System.in);

	        // Reads the actual and expected day, month, year from user as input
	        int actualDay = scan.nextInt();
	        int actualMonth = scan.nextInt();
	        int actualYear = scan.nextInt();

	        int expectedDay = scan.nextInt();
	        int expectedMonth = scan.nextInt();
	        int expectedYear = scan.nextInt();

	        // Close the Scanner class object after reading input from user
	        scan.close();

	        // Calculate the days, months and year difference between expected and actual return dates
	        int daysLate = actualDay - expectedDay;
	        int monthsLate = actualMonth - expectedMonth;
	        int yearLate = actualYear - expectedYear;

	        // If book returned after expected year
	        if(yearLate > 0){
	            System.out.println("10000"); // fine of 10000
	        }
	        // If book returned after expected month, but in the same year
	        else if((monthsLate > 0) && (actualYear == expectedYear)){
	            System.out.println(monthsLate * 500); // fine of (monthsLate * 500)
	        }
	        // If book returned after expected date, but same month and same year
	        else if((daysLate > 0) && (monthsLate == 0) && (yearLate == 0)){
	            System.out.println(daysLate * 15); // fine of (daysLate * 15)
	        }
	        // If book is returned as per expected date, month, and year
	        else{
	            System.out.println("0"); // then no fine is charged
	        }

	    }

}
