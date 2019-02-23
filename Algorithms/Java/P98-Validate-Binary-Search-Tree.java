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
    public boolean isValidBST(TreeNode root) {
        if (root == null) 
            return true;
        
        return isBSTUtil(root, null, null);
    }
    
    private boolean isBSTUtil(TreeNode node, Integer lower, Integer upper) {
        if ((lower != null) && (node.val <= lower)) 
            return false;
        if ((upper != null) && (node.val >= upper))
            return false;
        
        boolean left = node.left != null ? isBSTUtil(node.left, lower, node.val) : true;
        if (left) {
            boolean right = node.right != null ? isBSTUtil(node.right, node.val, upper) : true;
            return right;
        } else 
            return false;
    }
}