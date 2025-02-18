import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class RootToLeaf {
    Node root;

    RootToLeaf() {
        root = null;
    }

    // Function to build tree from level order input handling '-1' as null
    void buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return; // Empty or null tree

        Queue<Node> queue = new LinkedList<>();
        root = new Node(arr[0]);
        queue.add(root);

        int i = 1;
        while (i < arr.length) {
            Node temp = queue.poll();

            // Insert left child
            if (arr[i] != -1) {
                temp.left = new Node(arr[i]);
                queue.add(temp.left);
            }
            i++;

            // Insert right child
            if (i < arr.length && arr[i] != -1) {
                temp.right = new Node(arr[i]);
                queue.add(temp.right);
            }
            i++;
        }
    }

    // Inorder traversal (corrected output to stdout)
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + ", ");
            inorder(root.right);
        }
    }

    // Method to get all root-to-leaf paths
    List<String> binaryTreePaths(Node root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, "", result);
        return result;
    }

    // DFS helper function
    void dfs(Node node, String path, List<String> result) {
        if (node == null) return;

        path += node.data;

        // If leaf node, add the path to result
        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            path += "->"; // Append arrow before going deeper
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();  // Height of the tree
        int n = (int) Math.pow(2, h + 1) - 1;  // Maximum possible nodes in a full binary tree
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        RootToLeaf tree = new RootToLeaf();
        tree.buildTree(arr);

        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("All Binary Tree Paths: " + tree.binaryTreePaths(tree.root));

        sc.close();
    }
}
