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

public class PreOrder {
    static void preOrder(Node root, ArrayList<Integer> bag) {
        if (root != null) {
            bag.add(root.val);
            preOrder(root.left, bag);
            preOrder(root.right, bag);
        }
    }

    static ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> bag = new ArrayList<>();
        preOrder(root, bag);
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
        ArrayList<Integer> input = new ArrayList<>();

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of nodes and then provide values for each level of the tree");
        String sizeString = scn.next();
        int size = Integer.parseInt(sizeString);
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the value of node: " + i);
            String nodeString = scn.next();
            input.add(Integer.parseInt(nodeString));
        }

        Node root0 = new Node(input.get(0));

        createTree(root0, input);

        ArrayList<Integer> result = preOrder(root0);

        for (Integer node : result) {
            System.out.print(node + " ");
        }

        scn.close();
    }
}
