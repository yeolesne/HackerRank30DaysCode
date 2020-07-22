/*
 * Objective:
Today we're working with Linked Lists. Check out the Tutorial tab for learning materials and an instructional video!

A Node class is provided for you in the editor. A Node object has an integer data field, data, and a Node instance pointer, next, pointing to another node (i.e.: the next node in a list).

A Node insert function is also declared in your editor. It has two parameters: a pointer, head, pointing to the first node of a linked list, and an integer data value that must be added to the end of the list as a new Node object.

Task:

Complete the insert function in your editor so that it creates a new Node (pass data as the Node constructor argument) and inserts it at the tail of the linked list referenced by the head parameter. Once the new node is added, return the reference to the head node.

Note: If the head argument passed to the insert function is null, then the initial list is empty.

Input Format:

The insert function has 2 parameters: a pointer to a Node named head, and an integer value, data.
The constructor for Node has 1 parameter: an integer value for the data field.

You do not need to read anything from stdin.

Output Format:

Your insert function should return a reference to the head node of the linked list.

Sample Input:

The following input is handled for you by the locked code in the editor:
The first line contains T, the number of test cases.
The T subsequent lines of test cases each contain an integer to be inserted at the list's tail.

4
2
3
4
1

Sample Output:

The locked code in your editor prints the ordered data values for each element in your list as a single line of space-separated integers:

2 3 4 1

Explanation:

T = 4, so the locked code in the editor will be inserting 4 nodes.
The list is initially empty, so head is null; accounting for this, our code returns a new node containing the data value 2 as the head of our list. We then create and insert nodes 3, 4, and 1 at the tail of our list. The resulting list returned by the last call to insert is [2, 3, 4, 1], so the printed output is 2 3 4 1.

LinkedListExplanation.png    // https://www.hackerrank.com/challenges/30-linked-list/problem
 */

package com.sjsu.edu.code.practice;

import java.util.*;

class Node {
	int data;
	Node next;
	Node(int d) {
        data = d;
        next = null;
    }
}

public class LinkedListDemo {

	//Insert the nodes at tail of LL
    public static  Node insert(Node head,int data) {
        //Complete this method
        if(head == null){ // Check if the head is null
            Node newNode = new Node(data); // Insert the new node
            head = newNode; // Assign the newly added node as the head node to return as a reference to head
        }
        else{
            Node temp = new Node(data); // When head node is not null, create rest of the nodes
            // code to point next reference to the newly added nodes
            Node current = head; // Setting head as current node to traverse the LL
            while(current.next != null){ // Checking if next node of current node is not null
                current = current.next; // If true, then assign the next node of current node to the current variable
            }
            current.next = temp; // If next node of current node is null, then set the pointer of current node to the newly added node  (2 -> 3 -> 4 - > 1)
        }

        return head; // Return the reference to the head parameter
    
    }

    //Display method
	public static void display(Node head) {
        Node start = head; // Assign head node to the start variable to traverse through the LL
        while(start != null) { // Checking if the current node is not null
            System.out.print(start.data + " "); // If not null, print the data of the current node + space
            start = start.next; // Then assign the next node of start node (head node) as start node    op -> (2 3 4 1)
        }
    }

	//Main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}