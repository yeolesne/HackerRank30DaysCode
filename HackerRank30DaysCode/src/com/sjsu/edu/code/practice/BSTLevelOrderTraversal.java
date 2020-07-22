/*
 * Objective:
Today, we're going further with Binary Search Trees. Check out the Tutorial tab for learning materials and an instructional video!

Task:

A level-order traversal, also known as a breadth-first search, visits each level of a tree's nodes from left to right, top to bottom. You are given a pointer, root, pointing to the root of a binary search tree. Complete the levelOrder function provided in your editor so that it prints the level-order traversal of the binary search tree.

Hint: You'll find a queue helpful in completing this challenge.

Input Format:

The locked stub code in your editor reads the following inputs and assembles them into a BST:
The first line contains an integer, T (the number of test cases).
The T subsequent lines each contain an integer, data, denoting the value of an element that must be added to the BST.

Output Format:

Print the data value of each node in the tree's level-order traversal as a single line of N space-separated integers.

Sample Input:

6
3
5
4
7
2
1

Sample Output:

3 2 5 1 4 7 

Explanation:

The input forms the following binary search tree:
Refer the link below for explanation

https://www.hackerrank.com/challenges/30-binary-trees/problem

BST.png

We traverse each level of the tree from the root downward, and we process the nodes at each level from left to right. The resulting level-order traversal is 3 -> 2 -> 5 -> 1 -> 4 -> 7, and we print these data values as a single line of space-separated integers.
 */

package com.sjsu.edu.code.practice;

import java.util.*;

class Node{
    Node left,right; // Declare left and right nodes of a BST
    int data; // Declare the data
    Node(int data){
        this.data=data; // Initialize the data
        left=right=null; // Initialize the left and right nodes of a tree to null
    }
}

public class BSTLevelOrderTraversal{
    static LinkedList queue = new LinkedList(); // Implementing queue using LL

    public static void enqueue(Node n){ // Add nodes to the queue
        queue.addLast(n); // Adding at the tail of LL (rear end of queue)
    }

    public static Node dequeue(){ // Removing nodes from queue
        return (Node) queue.remove(0); // Removing from the head of LL (front end of queue)
    }

    public static boolean isEmpty(){ // Check if the queue is empty
        return queue.isEmpty();
    }

static void levelOrder(Node root){ // BFS traversal function
      //Write your code here
      if(root != null){ // If the root is not null
    	  BSTLevelOrderTraversal.enqueue(root); // Add the root node to queue
      }

      while(!(BSTLevelOrderTraversal.isEmpty())){ // While queue is not empty
          Node node = BSTLevelOrderTraversal.dequeue(); // Remove the first element at front of queue
          System.out.print(node.data + " "); // Print the node value (data) on console

          if(node.left != null){ // Process the left child, if not null
        	  BSTLevelOrderTraversal.enqueue(node.left); // Add the left node to queue
          }

          if(node.right != null){ // Process the right child, if not null
        	  BSTLevelOrderTraversal.enqueue(node.right); // Add the right child to queue
          }
      }   
    }

//Insert function
public static Node insert(Node root,int data){ // Root node as a pointer reference and data to be added passed as arguments
        if(root==null){ // If tree is empty
            return new Node(data); // Add the data at root
        }
        else{
            Node cur;
            if(data<=root.data){ // If data to be added is less than root node, add the data to the left 
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data); // else, add the data to the right
                root.right=cur;
            }
            return root; // Return root node
        }
    }

	//Main method
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in); // Creating the Scanner class object
            int T=sc.nextInt(); // Reads number of nodes from user
            Node root=null; // Initialize the root node to be null
            while(T-->0){ // For each node
                int data=sc.nextInt(); // Reads the data from user
                root=insert(root,data); // Insert the data in a tree and form Binary Search Tree
            } 
            levelOrder(root); //Call the levelOrder function with reference to the root node
            
            sc.close(); // Closing the Scanner class object
        }	
}

