import java.util.ArrayList;
import java.util.Stack;

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

/* non-recursion */
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList();
        if (root == null)
            return res;

        Stack<Node> st = new Stack();
        st.push(root);
        while (!st.isEmpty()) {
            root = st.pop();
            res.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; --i) {
                st.push(root.children.get(i));
            }
        }

        return res;
    }
}

/* recursion */
class Solution {
    
    List<Integer> res = new ArrayList();
    
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return res;
        }
        
        res.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        
        return res;
    }
}