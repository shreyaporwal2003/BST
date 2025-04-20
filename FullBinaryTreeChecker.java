import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class FullBinaryTreeChecker {
    static Scanner scanner = new Scanner(System.in);

    // Function to check if a tree is a Full Binary Tree
    public static boolean isFullBinaryTree(Node root) {
        if (root == null) {
            return true;
        }

        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            return false;
        }

        return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);
    }

    // Function to build a binary tree from user input
    public static Node buildTree() {
        System.out.print("Enter node value (-1 for null): ");
        int data = scanner.nextInt();

        if (data == -1) {
            return null;  // Base case for recursion
        }

        Node node = new Node(data);
        System.out.println("Enter left child of " + data);
        node.left = buildTree();
        System.out.println("Enter right child of " + data);
        node.right = buildTree();

        return node;
    }

    public static void main(String[] args) {
        System.out.println("Build the binary tree:");
        Node root = buildTree(); // Constructing the tree based on user input

        if (isFullBinaryTree(root)) {
            System.out.println("The tree is a Full Binary Tree.");
        } else {
            System.out.println("The tree is NOT a Full Binary Tree.");
        }

        scanner.close();
    }
}
