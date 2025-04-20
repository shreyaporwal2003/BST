import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
        
    }
}
public class TreePathFinder{
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
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);

        ArrayList<Integer> path=new ArrayList<>();
        int target=5;
        
        if(findPath(root,target,path)){
            System.out.print("Path to node: "+ path);
        }else{
            System.out.println("Node not found.");
        }
        
        
    }
}