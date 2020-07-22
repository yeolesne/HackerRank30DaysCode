/*
 * Objective:
Today we're expanding our knowledge of Strings and combining it with what we've already learned about loops. Check out the Tutorial tab for learning materials and an instructional video!

Task:
Given a string, S, of length N that is indexed from 0 to N-1, print its even-indexed and odd-indexed characters as 2 space-separated strings on a single line (see the Sample below for more detail).

Note: 0 is considered to be an even index.

Input Format:

The first line contains an integer, T (the number of test cases).
Each line i of the T subsequent lines contain a String, S.

Constraints:

1 <= T <= 10
2 <= length of S <= 10000

Output Format:

For each String Sj (where 0 <= j <= T-1), print Sj's even-indexed characters, followed by a space, followed by Sj's odd-indexed characters.

Sample Input:

2
Hacker
Rank

Sample Output:

Hce akr
Rn ak

Explanation:

Test Case 0: S = "Hacker"
s[0] = "H";
s[1] = "a";
s[2] = "c";
s[3] = "k";
s[4] = "e";
s[5] = "r";

The even indices are 0, 2, and 4, and the odd indices are 1, 3, and 5. We then print a single line of 2 space-separated strings; the first string contains the ordered characters from S's even indices (Hce), and the second string contains the ordered characters from S's odd indices (akr).

Test Case 1: S = "Rank"
s[0] = "R";
s[1] = "a";
s[2] = "n";
s[3] = "k";

The even indices are 0 and 2, and the odd indices are 1 and 3. We then print a single line of 2 space-separated strings; the first string contains the ordered characters from S's even indices (Rn), and the second string contains the ordered characters from S's odd indices (ak).  

 */

package com.sjsu.edu.code.practice;

import java.util.*;

public class Review {

    public static void spaceSeparatedString(String s){
        char c[] = s.toCharArray();

        for(int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
            i++;
        }
        System.out.print(" ");
        
        for(int j = 1; j < c.length; j++) {
            System.out.print(c[j]);
            j++;
        }
        
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i++){
            while(scanner.hasNextLine()){
                String input = scanner.next();
                Review.spaceSeparatedString(input);
                System.out.println();
            }
        
        }        
        scanner.close();
    }
}