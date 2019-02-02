/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // best solution   
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return root;
        
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        } else {
            return root;
        }
    }
}

// recursion 3 elements: 1. check validation 2. into recursion conditon 3. recursion operation