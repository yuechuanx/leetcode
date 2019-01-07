/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Vector;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Vector<Integer> res = new Vector<>();
        inOrderTraverse(root, res);
        return res.get(k - 1);
    }
    
    public void inOrderTraverse(TreeNode node, Vector<Integer> res) {
        if (node == null) return;
        if (node.left == null) {
            res.add(node.val);
        } else {
            inOrderTraverse(node.left, res);
            res.add(node.val);
        }
        if (node.right != null) {
            inOrderTraverse(node.right, res);
        }
    }
}