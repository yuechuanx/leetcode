/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (37.98%)
 * Total Accepted:    141.5K
 * Total Submissions: 372.5K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }

        return inPos2Tree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode inPos2Tree(int[] in, int iIn, int jIn, int[] pos, int iPos, int jPos, Map<Integer, Integer> map) {
        /* 递归出口,也是最后一层叶子节点 */
        if (iPos > jPos) {
            return null;
        }

        TreeNode head = new TreeNode(pos[jPos]);
        int index = map.get(pos[jPos]);
        head.left = inPos2Tree(in, iIn, index - 1, pos, iPos, iPos + index - iIn - 1, map);  // index - iIn = 左子树长度
        head.right = inPos2Tree(in, index + 1, jIn, pos, iPos + index - iIn, jPos - 1, map);
        
        return head;
    }
}

