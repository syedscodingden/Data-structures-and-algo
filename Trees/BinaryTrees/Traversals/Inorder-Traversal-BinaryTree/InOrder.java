// *********InOrder Traversal of Binary Tree ( Recursive Method)*********
// For the problem description refer to GFG
// Link: https://www.geeksforgeeks.org/problems/inorder-traversal/1

// Problem Description
// Given a binary tree, find its inorder traversal.

// The output is the inOrder of the created tree
// The important functions are inOrder(root) and inOrderHelper(root, bag), the former takes the root of the created tree and uses the latter to get the inorder of the created tree
// inOrderHelper takes the root and an ArrayList bag to store the output of the inorder which is later printed using for each loop

import java.io.IOException;
import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class InOrder {
    static void inOrderHelper(Node root, ArrayList<Integer> bag) {
        if (root != null) {
            inOrderHelper(root.left, bag);
            bag.add(root.val);
            inOrderHelper(root.right, bag);
        }

    }

    // Function to return a list containing the inorder traversal of the tree.
    static ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> bag = new ArrayList<>();
        inOrderHelper(root, bag);
        return bag;
    }

    public static void createTree(Node root0, ArrayList<Integer> v) {
        // Code here
        Queue<Node> q = new LinkedList<>();

        q.offer(root0);
        int i = 1;
        int n = v.size();

        while (q.size() != 0 && i < n) {
            Node root = q.poll();

            root.left = new Node(v.get(i++));
            q.offer(root.left);

            root.right = new Node(v.get(i++));
            q.offer(root.right);
        }
    }

    public static void main(String args[]) throws IOException {
        Integer[] nodeValuesLevelWise = { 1, 2, 3, 4, 5, 6, 7 };

        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(nodeValuesLevelWise));

        // ** This code can be used to pass custom node values level wise
        // ** Uncomment to use this for entering your own values

        // Scanner scn = new Scanner(System.in);
        // System.out.println("Enter the number of nodes and then provide values for
        // each level of the tree");
        // String sizeString = scn.next();
        // int size = Integer.parseInt(sizeString);
        // for (int i = 0; i < size; i++) {
        // System.out.println("Enter the value of node: " + i);
        // String nodeString = scn.next();
        // input.add(Integer.parseInt(nodeString));
        // }
        // scn.close();

        Node root0 = new Node(input.get(0));

        createTree(root0, input);

        ArrayList<Integer> result = inOrder(root0);

        for (Integer node : result) {
            System.out.print(node + " ");
        }
    }
}
