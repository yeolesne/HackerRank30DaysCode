/*
 * Objective:
Today, we're working with regular expressions. Check out the Tutorial tab for learning materials and an instructional video!

Task:

Consider a database table, Emails, which has the attributes First Name and Email ID. Given N rows of data simulating the Emails table, print an alphabetically-ordered list of people whose email address ends in @gmail.com.

Input Format:

The first line contains an integer, N, total number of rows in the table.
Each of the N subsequent lines contains 2 space-separated strings denoting a person's first name and email ID, respectively.

Constraints:

1. 2 <= N <= 30
2. Each of the first names consists of lower case letters [a-z] only.
3. Each of the email IDs consists of lower case letters [a-z], @ and . only.
4. The length of the first name is no longer than 20.
5. The length of the email ID is no longer than 50.

Output Format:

Print an alphabetically-ordered list of first names for every user with a gmail account. Each name must be printed on a new line.

Sample Input:

6
riya riya@gmail.com
julia julia@julia.me
julia sjulia@gmail.com
julia julia@gmail.com
samantha samantha@gmail.com
tanya tanya@gmail.com

Sample Output:

julia
julia
riya
samantha
tanya

Steps to Solve:

1. Define the Regular Expression for Email ID
2. Create a Pattern object
3. Create a List of type String to store the first names with matched Email ID pattern
4. Inside the for loop, create a Matcher object to match Email Id for each row with the specified pattern
5. If match found, then add the first name in list
6. Sort the list (ASC order)
7. Traverse through the list of first names and print each of them on new line

Note:

Arrays.sort() does work on strings. But in our case, we're creating the names array of max-size, and adding only a few string elements (first names) to it. Arrays.sort() does not work when there are unassigned elements in the array - Null Pointer Exception.

The workaround will be to use a List, and then Collections.sort() on it.

Or to create a smaller array, once you know how many elements you need, and then copy from the larger array to the smaller one. Now run the sort on the smaller (all elements assigned) array.

-> Code:

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), k=0;
        String[] names = new String[N];
        String regex = "[a-z]+@gmail\\.com$";
        Pattern p = Pattern.compile(regex);

        for(int i = 0; i < N; i++){
            String firstName = in.next();
            String emailId = in.next();

            Matcher m = p.matcher(emailId);
            if(m.find()) {
                //System.out.println(firstName);
                names[k++] = firstName;
            }
        }
        String[] names2 = new String[k];
        System.arraycopy(names, 0, names2, 0, k);


        Arrays.sort(names2);

        for (int i =0; i<names2.length; i++) {
            System.out.println(names2[i]);
        }
    }

 */

//Code using 'list' and 'Collections.sort()'

package com.sjsu.edu.code.practice;

import java.util.*;
import java.util.regex.*;

public class RegularExpression {
	
	// Create a Scanner class object 
	private static final Scanner scanner = new Scanner(System.in);

	// Main method
    public static void main(String[] args) {
    	// Reads the total number of rows in database from user
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        // Define the Regular Expression for Email ID
        String myRegExpression = "[a-z]+@gmail\\.com";
        
        // Create a Pattern object
        Pattern p = Pattern.compile(myRegExpression);
        
        // Create a List of type String to store the first names with matched Email ID pattern
        List<String> list = new ArrayList<String>();
        
        // for loop to traverse through each row
        for (int NItr = 0; NItr < N; NItr++) {
        	
        	// Store the space separated "First Name" and "Email ID" in a String array
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            // Store First Name in "firstName" variable
            String firstName = firstNameEmailID[0];

            // Store Email ID in "emailID" variable
            String emailID = firstNameEmailID[1];

            // Inside the for loop, create a Matcher object to match Email Id for each row with the specified pattern
            Matcher m = p.matcher(emailID);

            // If match found, then add the first name in list
            if(m.find()){
               list.add(firstName); 
            }

        } // for loop ends
        
        // Close the Scanner class object
        scanner.close();
        
        // Sort the list (ASC order)
        Collections.sort(list);
        
        // Traverse through the list of first names and print each of them on new line
        for(String name: list){ // name -> variable of type String
            System.out.println(name);
        }
        
    } // End of Main method

} // End of class
