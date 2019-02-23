public List<List<Integer>> pathSum(TreeNode root, int sum){
	List<List<Integer>> result  = new LinkedList<List<Integer>>();
	List<Integer> currentResult  = new LinkedList<Integer>();
	pathSum(root,sum,currentResult,result);
	return result;
}

public void pathSum(TreeNode root, int sum, List<Integer> currentResult,
		List<List<Integer>> result) {

	if (root == null)
		return;
	currentResult.add(new Integer(root.val));
	if (root.left == null && root.right == null && sum == root.val) {
		result.add(new LinkedList(currentResult));
		currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
		return;
	} else {
		pathSum(root.left, sum - root.val, currentResult, result);
		pathSum(root.right, sum - root.val, currentResult, result);
	}
	currentResult.remove(currentResult.size() - 1);
}

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        pathSumUtil(res, new ArrayList(), root, sum);
        
        return res; 
    }
    
    private void pathSumUtil(List<List<Integer>> res, List<Integer> path, TreeNode node, int sum) {
        if (node == null) return;
        path.add(new Integer(node.val));
        if (node.left == null && node.right == null && sum == node.val) {
            res.add(new ArrayList(path));
            path.remove(path.size() - 1);
            return;
        } else {
            pathSumUtil(res, path, node.left, sum - node.val);
            pathSumUtil(res, path, node.right, sum - node.val);
        }
        
        path.remove(path.size() - 1);
    } 
}

