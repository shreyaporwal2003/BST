import java.util.*;
class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}

public class TopViewInBST {
    Node root;

    TopViewInBST(){
        root=null;
    }
    
    
    void topView(Node root){
        if (root==null) return;
        class QueueNode{
        Node node;
        int vd;

        QueueNode(Node node, int vd) {
            this.node=node;
            this.vd=vd;
        }

        
        }
        Queue<QueueNode> q=new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        q.add(new QueueNode(root, 0));
        
        while(!q.isEmpty()){
            QueueNode temp=q.poll();
            Node node=temp.node;
            int vd=temp.vd;

            // Store first node at each horizontal distance
            if(!map.containsKey(vd)){
                map.put(vd,node.data);

            }
            // Traverse left and right children
            if(node.left!=null){
                q.add(new QueueNode(node.left,vd-1));
            }
            if(node.right!=null){
                q.add(new QueueNode(node.right,vd+1));
            }



            
        }
        System.out.println("Top view: ");
        for(int val:map.values()){
            System.out.print(val+", ");
        }
    }
    void topView(){
        topView(root);
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
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TopViewInBST tree=new TopViewInBST();
        System.out.println("Enter the number of nodes BST have: ");
        int n=sc.nextInt();
        
        for(int i=1;i<=n;i++){
            System.out.println("Enter the node:");
            int item=sc.nextInt();

            tree.insert(item);
        }
        tree.topView();
        sc.close();

        
    }
}
