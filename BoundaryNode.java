import java.util.*;

class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data=data;
        left=right=null;
    }
}
class BoundaryNode{
    Node root;

    public BoundaryNode() {
        root=null;
    }
    Node insert( Node root, int data){
        if(root==null){
            return new Node(data);
        }
        if(data<root.data){
            root.left=insert(root.left,data);
        }
        if(data>root.data){
            root.right=insert(root.right,data);
        }
        return root;


    }
    void insert(int data){
        insert(root,data);
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BoundaryNode tree=new BoundaryNode();
        System.out.println("Enter the number of nodes BST have: ");
        int n=sc.nextInt();
        
        for(int i=1;i<=n;i++){
            System.out.println("Enter the node:");
            int item=sc.nextInt();

            tree.insert(item);
        }
        sc.close();
        
    }
}