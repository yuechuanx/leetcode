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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            List<Integer> currLevel = new LinkedList();
            int len = queue.size();
            
            for (int i = 0; i < len; ++i) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
            
            int n = currLevel.size();
            double sum = 0;
            for (int num : currLevel) {
                sum += num;
            }
            res.add(sum / n);
        }
        
        return res;
        
    }
}