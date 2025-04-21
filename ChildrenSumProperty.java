
import java.util.*;
class TreeNode{
    int val;
    TreeNode left,right;
    public TreeNode(int data){
        this.val=data;
        this.left=null;
        this.right=null;
    }
}
public class ChildrenSumProperty {
    TreeNode root;
    public ChildrenSumProperty(){
        root=null;

    }
    void insertTree(int data){
        TreeNode newNode=new TreeNode(data);
        if(root==null){
            root=newNode;
            return;
        }
        Queue<TreeNode> q=new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp.left==null){
                temp.left=newNode;
                return;
            }
            else{
                q.offer(temp.left);
            }
            if(temp.right==null){
                temp.right=newNode;
                return;
            }
            else{
                q.offer(temp.right);
            }

        }
    }
    void changeTree(TreeNode root){
        if(root==null){
            return;
        }
        int child=0;
        if(root.left!=null) child+=root.left.val;
        if(root.right!=null) child+=root.right.val;

        if(child>=root.val) root.val=child;
        else{
            if(root.left!=null) root.left.val=root.val;
            if(root.right!=null) root.right.val=root.val;
        }

        changeTree(root.left);
        changeTree(root.right);

        int tot=0;
        if(root.left!=null) tot+=root.left.val;
        if(root.right!=null) tot+=root.right.val;

        if(tot>=root.val) root.val=tot;
    }
    void inorder(TreeNode node){
        if(node!=null){
            inorder(node.left);
            System.out.print(node.val+" ");
            inorder(node.right);
        }
    }
    void inorderTraversal(){
         inorder(root);
    }
    void change(){
        changeTree(root);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ChildrenSumProperty tree=new ChildrenSumProperty();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            tree.insertTree(a);

        }
         System.out.println("Before: ");
        tree.inorderTraversal();
        tree.change();
        System.out.println("After: ");
        tree.inorderTraversal();


    }
    
}
