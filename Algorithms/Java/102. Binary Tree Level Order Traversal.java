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