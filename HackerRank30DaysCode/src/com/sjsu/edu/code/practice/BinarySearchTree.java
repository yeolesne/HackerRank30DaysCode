/*
 * Objective:
Today, we're working with Binary Search Trees (BSTs). Check out the Tutorial tab for learning materials and an instructional video!

Task:

The height of a binary search tree is the number of edges between the tree's root and its farthest leaf. You are given a pointer, root, pointing to the root of a binary search tree. Complete the getHeight function provided in your editor so that it returns the height of the binary search tree.

Input Format:

The locked stub code in your editor reads the following inputs and assembles them into a binary search tree:
The first line contains an integer, n, denoting the number of nodes in the tree.
Each of the n subsequent lines contains an integer, data, denoting the value of an element that must be added to the BST.

Output Format:

The locked stub code in your editor will print the integer returned by your getHeight function denoting the height of the BST.

Sample Input:

7
3
5
2
1
4
6
7

Sample Output:

3

Explanation:

The input forms the following BST:
[Refer to the below link for figures:

https://www.hackerrank.com/challenges/30-binary-search-trees/problem]

BST.png

The longest root-to-leaf path is shown below:

Longest RTL.png

There are 4 nodes in this path that are connected by 3 edges, meaning our BST's height = 3. Thus, we print 3 as our answer.
 */

package com.sjsu.edu.code.practice;

import java.util.*;

class Node{
    Node left,right; // Declare left and right child of a tree
    int data; // Declare the data field
    Node(int data){ // Constructor that initializes the data, left, and right children of a tree
        this.data=data;
        left=right=null;
    }
}

public class BinarySearchTree{

	// Method to determine height of a Binary tree
	public static int getHeight(Node root){
      //Write your code here
      if(root == null){ // If tree is empty
          return -1;
      }
      else if(root.left == null && root.right == null) // If tree has one element - root
      {
          return 0;
      }
      else{
          int leftHeight = 0; // Variables to keep track of left and right subtree height
          int rightHeight = 0;
          if(root.left != null){ // Traverse the left subtree
              leftHeight = getHeight(root.left);
          }
          if(root.right != null){ // Traverse the right subtree
              rightHeight = getHeight(root.right);
          }
          return (leftHeight > rightHeight) ? (leftHeight + 1) : (rightHeight + 1); // Check max(leftHeight, rightHeight) and add 1 to the max height
      }

    }

	// Insert function
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
        int height=getHeight(root); // Call the getHeight function with argument root node as a pointer
        System.out.println(height); // Prints the height on console
    }
}
