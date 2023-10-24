/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // Runtime: 2 ms, faster than 10.28% of Java online submissions for Binary Tree Postorder Traversal.
class Solution {
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<NodeOp> path = new ArrayDeque<>();
        
        path.addFirst(new NodeOp(0, root));
        
        while (!path.isEmpty()) {
            NodeOp curr = path.removeFirst();
            if (curr.node == null) continue;    // defensive;
            if (curr.op == 1) res.add(curr.node.val);
            else {
                path.addFirst(new NodeOp(1, curr.node));
                path.addFirst(new NodeOp(0, curr.node.right));
                path.addFirst(new NodeOp(0, curr.node.left));
            }
        }
        
        return res;
    }
    
    private class NodeOp {
        int op;
        TreeNode node;
        
        public NodeOp(int op, TreeNode node) {
            this.op = op;
            this.node = node;
        }
    }    
    
}

