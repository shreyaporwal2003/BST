import java.util.Scanner;

class Node{
    int data;
    Node left, right;
    public Node(int item){
        data=item;
        left=right=null;
    }
}
class BST{
    Node root;
    BST(){
        root=null;
    }
    Node insert(Node root, int item){
        if(root==null){
            return new Node(item);
        }
        if(item<root.data){
            root.left=insert(root.left,item);
        }else if(item>root.data){
            root.right=insert(root.right,item);
        }
        return root;
    }
    void insert(int item){
        root=insert(root,item);
    }
    void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.err.print(root.data+", ");
            inorder(root.right);
        }
    }
    void inorder(){
        inorder(root);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BST tree=new BST();
        System.out.println("Enter the number of nodes BST have: ");
        int n=sc.nextInt();
        
        for(int i=1;i<=n;i++){
            System.out.println("Enter the node:");
            int item=sc.nextInt();

            tree.insert(item);
        }

        tree.inorder();
        sc.close();
        
    }

}