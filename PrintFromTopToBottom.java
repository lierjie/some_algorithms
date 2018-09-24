import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);        
        while(!q.isEmpty()){
            TreeNode tmp = q.remove();
            result.add(tmp.val);
            if(tmp.left != null){
                q.add(tmp.left);
            }

            if(tmp.right != null){
                q.add(tmp.right);

            }

        }

        return result;
    }
}