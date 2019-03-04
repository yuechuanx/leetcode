/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* 递归解法 */
class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left == null && t.right == null) {  // 叶节点，只需要打印值
            return t.val + "";
        }
        if (t.right == null) {  // 只有左节点，不打印右节点
            return t.val + "(" + tree2str(t.left) + ")";
        }
        
        /* 左右节点都不为空 */
        return t.val + "(" + tree2str(t.left) + ")("
            + tree2str(t.right) + ")";
    }
}

/* 非递归 */
class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        
        Stack < TreeNode > stack = new Stack < > ();
        stack.push(t);
        Set < TreeNode > visited = new HashSet < > ();
        StringBuilder s = new StringBuilder();
        
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null) {
                    s.append("()");
                }
                if (t.right != null) {
                    stack.push(t.right);
                }
                if (t.left != null) {
                    stack.push(t.left);
                }
                    
            }
        }
        
        return s.substring(1, s.length() - 1);
    }
}