import java.util.Scanner;

class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data=data;
        left=right=null;

    }

}
public class deleteNodeInBST {
    Node root;

    public deleteNodeInBST() {
        root=null;
    }
    Node insert( Node root, int data){
        if(root==null){
            return new Node(data);
        }
        if(data<root.data){
            root.left=insert(root.left,data);
        }
        else if(data>root.data){
            root.right=insert(root.right,data);
        }
        return root;


    }
    void insert(int data){
        root=insert(root,data);
    }
    public Node deleteNode(Node root, int key){
        if(root==null){
            return root;
        }
        if(key==root.data){
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.right==null){
                return root.left;
            }
            if(root.left==null){
                return root.right;
            }
            Node successor=findmin(root.right);
            root.data=successor.data;
            root.right=deleteNode(root.right, successor.data);
        }
        if(key<root.data){
            root.left=deleteNode(root.left, key);
        }
        if(key>root.data){
            root.right=deleteNode(root.right, key);
        }
        return root;


    }
    void delete(int key){
        root=deleteNode(root, key);
    }
    private Node findmin(Node node){
        while(node.left!=null){
            node=node.left;
        }
        return node;

    }
    void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+", ");
            inorder(root.right);
        }
    }
    void inorder(){
        inorder(root);
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        deleteNodeInBST tree = new deleteNodeInBST();
        System.out.println("Enter the number of nodes BST has: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter the node:");
            int item = sc.nextInt();
            tree.insert(item);
        }

        System.out.println("Enter the node value you want to delete: ");
        int key = sc.nextInt();

        System.out.println("Inorder before deletion:");
        tree.inorder();

        tree.delete(key);

        System.out.println("Inorder after deletion:");
        tree.inorder();

        sc.close();
        

        
    }
}
