/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // wrong solution, fix it.
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return traverse(root, root.val);
    }
    
    // it's wrong, because it will traverse the left-bottom node.
    private boolean traverse(TreeNode node, int val) {
        if (node.left != null) return traverse(node.left, val);
        else if (node.right != null) return traverse(node.right, val);
        else 
            return node.val == val ? true : false;
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