import java.util.*;

class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data=data;
        left=right=null;
    }
}
public class BoundaryNode{
    Node root;

    public BoundaryNode() {
        root=null;
    }
    void insert(int key){
        Node newNode=new Node(key);
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
    void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);

        }
    }
    void inorderTraversal(){
        inorder(root);
    }
    boolean isLeaf(Node node){
        if(node.left==null && node.right==null){
            return true;
        }
        return false;
        
    }
    void addLeft(ArrayList<Integer> res, Node root){
        Node cur=root.left;
        while(cur!=null){
            if(!isLeaf(cur)) res.add(cur.data);
            if(cur.left!=null) cur=cur.left;
            else cur=cur.right;
        }
    }
    void addLeaf(ArrayList<Integer> res, Node root){
        if(root==null){
            return;
        }
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        addLeaf(res,root.left);
        addLeaf(res,root.right);
    }
    void addRight(ArrayList<Integer> res, Node root){
        ArrayList<Integer> temp=new ArrayList<>();
        Node cur=root.right;
        while(cur!=null){
            if(!isLeaf(cur)) temp.add(cur.data);
            if(cur.right!=null) cur=cur.right;
            else cur=cur.left;
        }
        for(int i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }
    
    void boundaryTraversalOrder(Node root){
        ArrayList<Integer> res=new ArrayList<>();
        res.add(root.data);
        if(!isLeaf(root)){
            addLeft(res,root);
            addLeaf(res,root);
            addRight(res,root);
        }

        System.out.println("Boundary Traversal: "+ res);

    }
    void boundaryTraversal(){
        boundaryTraversalOrder(root);
    }

    
    public static void main(String[] args) {
        BoundaryNode tree=new BoundaryNode();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        System.out.println("Inorder Traversal:");
        tree.inorderTraversal();
        System.out.println();
        tree.boundaryTraversal();
        
    }
}

    
    