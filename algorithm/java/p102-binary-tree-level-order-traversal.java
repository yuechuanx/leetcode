/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (47.10%)
 * Total Accepted:    339.3K
 * Total Submissions: 720.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();

        if (root == null) return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList();
            int len = queue.size();
            for (int i = 0; i < len; ++i) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) 
                    queue.offer(curr.left);
                if (curr.right != null) 
                    queue.offer(curr.right);
            }
            res.add(level);
        }

        return res;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode last = root, nextLast = null;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> levelNode = new ArrayList<>();
            for (int i = 0; i < levelNum; ++i) {
                TreeNode head = queue.poll();
                levelNode.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                    nextLast = head.left;
                }
                if (head.right != null){
                    queue.offer(head.right);
                    nextLast = head.right;
                }
                if (head == last) {
                    last = nextLast;
                    res.add(levelNode);
                }
            }
        }
        
        return res;
    }
}