import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class CompleteBinaryTreeChecker {
    static Scanner scanner = new Scanner(System.in);

    // Function to check if a tree is a Complete Binary Tree
    public static boolean isCompleteBinaryTree(Node root) {
        if (root == null) return true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean encounteredNull = false;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == null) {
                encounteredNull = true; // If a null is encountered, all subsequent nodes should also be null
            } else {
                if (encounteredNull) return false; // If a non-null node appears after a null node, it's not a CBT

                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return true;
    }

    // Function to build a binary tree from user input
    public static Node buildTree() {
        System.out.print("Enter node value (-1 for null): ");
        int data = scanner.nextInt();

        if (data == -1) return null;

        Node node = new Node(data);
        System.out.println("Enter left child of " + data);
        node.left = buildTree();
        System.out.println("Enter right child of " + data);
        node.right = buildTree();

        return node;
    }

    public static void main(String[] args) {
        System.out.println("Build the binary tree:");
        Node root = buildTree();

        if (isCompleteBinaryTree(root)) {
            System.out.println("The tree is a Complete Binary Tree.");
        } else {
            System.out.println("The tree is NOT a Complete Binary Tree.");
        }

        scanner.close();
    }
}
