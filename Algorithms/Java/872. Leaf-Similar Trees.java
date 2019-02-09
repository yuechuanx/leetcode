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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // so we gotta write a func to find the leaf sequence
        List<Integer> leafSeq1 = new ArrayList();
        List<Integer> leafSeq2 = new ArrayList();
        dfs(root1, leafSeq1);
        dfs(root2, leafSeq2);
        // if (leafSeq1.size() != leafSeq2.size()) return false;
        //        return false;
        // }
        
        // return true;    
        return leafSeq1.equals(leafSeq2);
    }
    
    private void dfs(TreeNode node, List<Integer> leafSeq) {
        if (node != null) {
            if (node.left == null && node.right == null) leafSeq.add(node.val);
            dfs(node.left, leafSeq);
            dfs(node.right, leafSeq);
    
        }
    }
}