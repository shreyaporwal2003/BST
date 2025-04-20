import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class LevelOfNode {
    Node root;

    public LevelOfNode() {
        root = null;
    }

   
    int getLevel(Node root, int val, int level) {
        if (root == null) {
            return -1; 
        }
        if (root.data == val) {
            return level;
        }

     
        int leftLevel = getLevel(root.left, val, level + 1);
        if (leftLevel != -1) return leftLevel; 

      
        return getLevel(root.right, val, level + 1);
    }

    void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            if (curr.left == null) {
                curr.left = new Node(data);
                return;
            } else {
                q.add(curr.left);
            }

            if (curr.right == null) {
                curr.right = new Node(data);
                return;
            } else {
                q.add(curr.right);
            }
        }
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LevelOfNode tree = new LevelOfNode();

        System.out.println("Enter number of Nodes:");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            int node = sc.nextInt();
            tree.insert(node);
        }

        System.out.println("Inorder traversal:");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Enter the  level:");
        int val = sc.nextInt();

        int level = tree.getLevel(tree.root, val, 0);
        if (level != -1) {
            System.out.println("Level of node " + val + ": " + level);
        } else {
            System.out.println("Node not found.");
        }

        sc.close();
    }
}
