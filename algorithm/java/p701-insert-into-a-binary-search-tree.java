/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // original solution write by
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        TreeNode prev = findPrev(root, val);
        if (val < prev.val) prev.left = new TreeNode(val);
        else prev.right = new TreeNode(val);
        
        return root;
    }
    
    private TreeNode findPrev(TreeNode node, int val) {
        if (val < node.val && node.left == null) return node;
        else if (val > node.val && node.right == null) return node;
        else {
            return (val < node.val) ? findPrev(node.left, val) : findPrev(node.right, val);
        }
            
    }
}

// more elegant
class Solution {
    
    private TreeNode insertIntoBSTUtil(TreeNode root, int val, TreeNode node) {
        if(root==null) 
            return node;
        if(root.val > val)
            root.left=insertIntoBSTUtil(root.left,val,node);
        else
            root.right=insertIntoBSTUtil(root.right,val,node);
        return root;
    }
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertIntoBSTUtil(root,val,new TreeNode(val));
    }
}

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
      if(root == null) return new TreeNode(val);
      TreeNode cur = root;
      while(true) {
          if(cur.val <= val) {
              if(cur.right != null) cur = cur.right;
              else {
                  cur.right = new TreeNode(val);
                  break;
              }
          } else {
              if(cur.left != null) cur = cur.left;
              else {
                  cur.left = new TreeNode(val);
                  break;
              }
          }
      }
      return root;
  }
}