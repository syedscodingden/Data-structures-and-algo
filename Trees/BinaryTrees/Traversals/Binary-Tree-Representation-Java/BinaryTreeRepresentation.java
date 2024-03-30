import java.io.IOException;
import java.util.*;

import javax.lang.model.type.NullType;

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