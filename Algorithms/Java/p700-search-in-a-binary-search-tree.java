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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        TreeNode curr = root;
        while (curr != null) {
            if (val == curr.val) return curr;
            else if (val < curr.val) curr = curr.left;
            else  curr = curr.right;
        }
        
        return null;
    }
}

// recursion
public TreeNode searchBST(TreeNode root, int val) {
    if(root == null || root.val == val) return root;
    return val < root.val? searchBST(root.left, val): searchBST(root.right, val);
}

// iteration
public TreeNode searchBST(TreeNode root, int val) {
    while(root != null && root.val != val){
        root = val<root.val? root.left:root.right;
    }
    return root;
}
