import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
        
    }
}
public class LCA{
    private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode left=lca(root.left,p,q);
        TreeNode right=lca(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }

        return left!=null?left:right;
    }
    private static boolean findPath(TreeNode root, int target, List<Integer> path){
        if(root==null){
            return false;
        }
        path.add(root.val);
        if(root.val==target){
            return true;
        }
        if(findPath(root.left,target,path) || findPath(root.right,target,path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(5);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);

        int p=5;
        int q=4;

        ArrayList<Integer> path1=new ArrayList<>();
        ArrayList<Integer> path2=new ArrayList<>();

        findPath(root,p,path1);
        findPath(root,q,path2);

        System.out.println(path1);
        System.out.println(path2);


        int m=path1.size();
        int n=path2.size();
        int i=0;
        int j=0;
        while(i<m && j<n){
            if(path1.get(i)==path2.get(j)){
                i++;
                j++;
            }
            else{
                break;
            }
        }

        System.out.println("LCA: "+path2.get(j-1));

        TreeNode p1 = root.left;                 // Node with value 5
        TreeNode q1 = root.left.right.right;    // Node with value 4

        System.out.print(lca(root,p1,q1).val);



    
        
        
        
        
        
    }
}