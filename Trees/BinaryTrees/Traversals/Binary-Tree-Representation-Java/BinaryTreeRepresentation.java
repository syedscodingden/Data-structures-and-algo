// For the problem description refer to GFG
// Link: https://www.geeksforgeeks.org/problems/binary-tree-representation/1

// Problem Description
// You are given an array nodes. It contains 7 integers, which represents the value of nodes of the binary tree in level order traversal. 
// You are also given a root of the tree which has a value equal to nodes[0].
// Your task to construct a binary tree by creating nodes for the remaining 6 nodes.

// The output is then given as the preOrder of the created Tree
// The important function is createTree(root, list[levelOrderTraversal]) which takes the root and the list of elements given as the level order traversal of the desired tree
// The output is verified by the preOrder function which prints the preOrder of the formed tree

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

class BinaryTreeRepresentation {

    ArrayList<Integer> input = new ArrayList<Integer>();

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

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String args[]) throws IOException {
        ArrayList<Integer> input = new ArrayList<>();

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        String sizeString = scn.next();
        int size = Integer.parseInt(sizeString);
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the value of node: " + i);
            String nodeString = scn.next();
            input.add(Integer.parseInt(nodeString));
        }

        Node root0 = new Node(input.get(0));

        createTree(root0, input);

        preOrder(root0);

        scn.close();
    }
}