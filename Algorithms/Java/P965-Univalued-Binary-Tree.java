import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 class Solution {
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        
        return dfs(root, val);
    }
    
    private boolean dfs(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        if (node.val != val) {
            return false;
        }
        
        return dfs(node.left, val) && dfs(node.right, val);
    }
}

// use recursion, i think best solution.
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }
}


// convert to Array, use dfs
class Solution {
    List<Integer> vals;
    
    public boolean isUnivalTree(TreeNode root) {
        vals = new ArrayList();
        dfs(root);
        for (int v : vals) 
            if (v != vals.get(0))
                return false;
        return true;
    }
    
    private void dfs (TreeNode node) {
        if (node != null) {
            vals.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }
}