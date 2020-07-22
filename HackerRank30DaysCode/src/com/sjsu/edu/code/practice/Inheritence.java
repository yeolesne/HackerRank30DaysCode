/*
 * Objective:
Today, we're delving into Inheritance. Check out the attached tutorial for learning materials and an instructional video!

Task:
You are given two classes, Person and Student, where Person is the base class and Student is the derived class. Completed code for Person and a declaration for Student are provided for you in the editor. Observe that Student inherits all the properties of Person.

Complete the Student class by writing the following:

A Student class constructor, which has 4 parameters:
A string, firstName.
A string, lastName.
An integer, id.
An integer array (or vector) of test scores, scores.
A char calculate() method that calculates a Student object's average and returns the grade character representative of their calculated average:

Letter        Average
O             90<= avg <= 100
E			  80 <= avg < 90
A			  70 <= avg < 80
P			  55 <= avg < 70
D			  40 <= avg < 55
T			  avg < 40 			   

Input Format:

The locked stub code in your editor calls your Student class constructor and passes it the necessary arguments. It also calls the calculate method (which takes no arguments).

You are not responsible for reading the following input from stdin:
The first line contains firstName, lastName, and id, respectively. The second line contains the number of test scores. The third line of space-separated integers describes scores.

Constraints:

1 <= |firstName|, |lastName| <= 10
|id| = 7
0 <= score, average <= 100 

Output Format:

This is handled by the locked stub code in your editor. Your output will be correct if your Student class constructor and calculate() method are properly implemented.

Sample Input

Heraldo Memelli 8135627
2
100 80

Sample Output:

 Name: Memelli, Heraldo
 ID: 8135627
 Grade: O
 
Explanation:

This student had 2 scores to average: 100 and 80. The student's average grade is (100+80)/2 = 90. An average grade of 90 corresponds to the letter grade O, so our calculate() method should return the character 'O'.
 */

package com.sjsu.edu.code.practice;

import java.util.*;

class Person {      //No changes in given code here
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}

class Student extends Person{ // Code to be added in subclass only
	private int[] testScores;

    /*	
    *   Class Constructor
    *   
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */
    // Write your constructor here
    public Student(String firstName, String lastName, int id, int[] scores){
    	//Note: If a superclass does not have a default constructor, any subclasses extending it must make an explicit call to one of the superclass' parameterized constructors.
        //Two ways to call super class constructor from sub class....
    	//https://www.hackerrank.com/challenges/30-inheritance/tutorial
    	super(firstName, lastName, id); //Explicit call to the super class parameterized constructor
        this.testScores = scores;
    }

    public void printPerson(){
        super.printPerson(); //Calling the superclass's printPerson() method
    }

    /*	
    *   Method Name: calculate
    *   @return A character denoting the grade.
    */
    // Write your method here
    public char calculate(){
        int sum = 0;
        int avg = 0;
        char grade;
        for(int i = 0; i < testScores.length; i++){
            sum = sum + testScores[i];
        }
        avg = sum / testScores.length;

        if(avg < 40){
            grade = 'T';
        }else if(40 <= avg && avg < 55){
            grade = 'D';
        }else if(55 <= avg && avg < 70){
            grade = 'P';
        }else if(70 <= avg && avg < 80){
            grade = 'A';
        }else if(80 <= avg && avg < 90){
            grade = 'E';
        }else{
            grade = 'O';
        }

        return grade;
    }
}

public class Inheritence { //No changes in given code here
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate() );
	}
}


