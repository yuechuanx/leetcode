/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (25.25%)
 * Total Accepted:    361.7K
 * Total Submissions: 1.4M
 * Testcase Example:  '[2,1,3]'
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's
 * value
 * is 5 but its right child's value is 4.
 * 
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return isValidBST(root, null, null); 
    }

    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        /* 递归出口 */
        if (lower != null && node.val <= lower)  {
            return false;
        }
        if (upper != null && node.val >= upper) {
            return false;
        } 

        /* 递归块 */
        boolean left = (node.left != null) ? isValidBST(node.left, lower, node.val) : true;  // 如果左子树不为空，则下界为当前node值，上界不变，为空则返回true
        if (left) {  
            boolean right = (node.right != null) ? isValidBST(node.right, node.val, upper) : true;
            return right;
        } else {
            return false;
        }
    }
}

