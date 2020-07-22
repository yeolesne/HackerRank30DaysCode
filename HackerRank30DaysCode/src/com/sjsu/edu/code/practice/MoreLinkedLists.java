/*
 * Objective:
Check out the Tutorial tab for learning materials and an instructional video!

Task:

A Node class is provided for you in the editor. A Node object has an integer data field, data, and a Node instance pointer, next, pointing to another node (i.e.: the next node in a list).

A removeDuplicates function is declared in your editor, which takes a pointer to the head node of a linked list as a parameter. Complete removeDuplicates so that it deletes any duplicate nodes from the list and returns the head of the updated list.

Note: The head pointer may be null, indicating that the list is empty. Be sure to reset your next pointer when performing deletions to avoid breaking the list.

Input Format:

You do not need to read any input from stdin. The following input is handled by the locked stub code and passed to the removeDuplicates function:
The first line contains an integer, N, the number of nodes to be inserted.
The N subsequent lines each contain an integer describing the data value of a node being inserted at the list's tail.

Constraints:

The data elements of the linked list argument will always be in non-decreasing order.

Output Format:

Your removeDuplicates function should return the head of the updated linked list. The locked stub code in your editor will print the returned list to stdout.

Sample Input:

6
1
2
2
3
3
4

Sample Output:

1 2 3 4 

Explanation:

N = 6, and our non-decreasing list is {1,2,2,3,3,4}. The values 2 and 3 both occur twice in the list, so we remove the two duplicate nodes. We then return our updated (ascending) list, which is {1,2,3,4}.
 */

package com.sjsu.edu.code.practice;

import java.util.*;

class Node{
	int data; // Declare the data field 
	Node next; // Declare the pointer to next node
	Node(int d){
        data=d; // Initialize the data field
        next=null; // Initialize the pointer to next node
    }
}

public class MoreLinkedLists
{

	// Remove Duplicates method
	public static Node removeDuplicates(Node head) {
	      //Write your code here
	      if(head == null){ // If LL is empty
	          return null;
	      }
	      else if(head.next == null){ // Only one element in LL -> head
	          return head;
	      }
	      else{
	          Node start = head; // Assign head node as the current node
	          while(start.next != null){ // Traverse through the LL while next node of current node (start) is not null
	              if(start.data == start.next.data){ // Check if current node's data is equal to the next node of current node's data
	                  start.next = start.next.next; // If yes, delete the next node of current node
	              }
	              else{
	                  start = start.next; // else, keep assigning next node as the current node to traverse the LL
	              }
	          }
	          return head; // Return head element
	      }

	}

	
	 // Insert method
	 public static  Node insert(Node head,int data)
     {
        Node p=new Node(data);	// Creating a new node		
        if(head==null) // If LL is empty
            head=p; // Assign new node to head node
        else if(head.next==null) // If only one element in LL
            head.next=p; // Set the next pointer of head node to the newly added node
        else
        {
            Node start=head; // Assign head node as current node (start node)
            while(start.next!=null) // Traverse the LL until next node of current node is not null
                start=start.next; // Keep changing the current node to the next node
            start.next=p; // If next node of current node is null, then assign the next pointer of current node to newly added node (Adding new node at tail of LL)

        }
        return head; // Return the head element
    }
	
	 // Display method
    public static void display(Node head)
        {
              Node start=head; // Assign head node to the start node
              while(start!=null) // While start node is not null
              {
                  System.out.print(start.data+" "); // Prints the data on console
                  start=start.next; // Set the next node as current node (start node)
              }
        }
    
    
    	//Main method
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in); // Creating Scanner class object
              Node head=null; // Initialize the head to null
              int T=sc.nextInt(); // Reads number of nodes from user -> test cases
              while(T-->0){ // For each test cases
                  int ele=sc.nextInt(); // Reads the data from user
                  head=insert(head,ele); // Inserts the nodes in LL
              }
              head=removeDuplicates(head); // Calling removeDuplicates method with reference to the head node passed as an argument
              display(head); // Display the nodes in newly updated LL (after duplicates removal)
              
              sc.close(); // Closing the Scanner class object

       }
    }

