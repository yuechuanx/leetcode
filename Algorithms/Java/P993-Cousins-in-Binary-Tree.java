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
    public boolean isCousins(TreeNode root, int x, int y) {
         // level traverse, then find x, y in currlevel and idx(x), idx(y) not adjoint   
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            boolean _x = false;
            boolean _y = false;
            int len = queue.size();
            for (int i = 0; i < len; ++i) {
                TreeNode curr = queue.poll();
                if (curr.left != null && curr.right != null ) {
                    if ((curr.left.val == x && curr.right.val == y) || (curr.right.val == x && curr.left.val == y)) {
                    curr.left.val = -1;
                    curr.right.val = -1;
                    }

                }
                if (curr.val == x) _x = true;
                if (curr.val == y) _y = true;
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            if (_x && _y) return true;
        }
        
        return false;
    }
}