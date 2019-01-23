/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        // null condition
        if (root == null) 
            return 0;
        else if (root.children.isEmpty()) 
            return 1;
        else {
            List<Integer> heights = new LinkedList<>();
            for (Node item : root.children) 
                heights.add(maxDepth(item));
            return Collections.max(heights) + 1;
        }
    }    
}