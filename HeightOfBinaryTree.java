import java.util.*;
class  Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data=data;
        left=right=null;
    }
}
public class HeightOfBinaryTree{
    Node root;

    public HeightOfBinaryTree() {
        root=null;
    }
    void insert(int data){
        Node newNode=new Node(data);
        if(root==null){
            root=newNode;
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node temp=q.poll();
            if(temp.left==null){
                temp.left=newNode;
                break;

            }
            else{
                q.offer(temp.left);
            }
            if(temp.right==null){
                temp.right=newNode;
                break;
            }
            else{
                q.offer(temp.right);
            }
        }


    }
    void inorderTraversal(Node node){
        if(node!=null){
            inorderTraversal(node.left);
            System.out.print(node.data+ " ");
            inorderTraversal(node.right);

        }
    }
    void inorder(){
        inorderTraversal(root);
    }
    int height(){
        
        int h=heightOfBT(root);
        return h;
        

    }
    int heightOfBT(Node root){
        if(root==null) return 0;
        return 1+Math.max(heightOfBT(root.left),heightOfBT(root.right));
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HeightOfBinaryTree tree=new HeightOfBinaryTree();

        System.out.println("Enter the number of nodes in the tree: ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            tree.insert(a);
        }

        tree.inorder();
        System.out.println();
        System.out.println("Height of tree is: " + tree.height());
        


    


        
    }
}