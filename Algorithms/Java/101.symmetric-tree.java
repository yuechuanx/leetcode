/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (42.75%)
 * Total Accepted:    362.3K
 * Total Submissions: 847.3K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * But the following [1,2,2,null,3,null,3]  is not:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 */
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        TreeNode left, right; 
        Queue<TreeNode> lQueue = new LinkedList(), rQueue = new LinkedList();
        lQueue.offer(root.left);
        rQueue.offer(root.right);
        while (!lQueue.isEmpty() && !rQueue.isEmpty()) {
            left = lQueue.poll();
            right = rQueue.poll();
            if (left == null && right == null) {
                continue;
            } else if (left == null || right == null) {
                return false;
            } else if(left.val != right.val) {
                return false;
            }
            lQueue.offer(left.right);
            lQueue.offer(left.left);
            rQueue.offer(right.left);
            rQueue.offer(right.right);
        }

        return true;
    }
}

