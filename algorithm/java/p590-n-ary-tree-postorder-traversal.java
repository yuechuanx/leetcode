import java.util.ArrayList;
import java.util.Collections;
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
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList();
        if (root == null) return res;
        
        Stack<Node> st = new Stack();
        st.push(root);
        
        while (!st.isEmpty()) {
            root = st.pop();
            res.add(root.val);
            for (Node node : root.children) 
                st.push(node);
        }
        
        Collections.reverse(res);
        return res;
    }
}

class Solution {
    
    List<Integer> res = new ArrayList();
    
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return res;
        }
        
        for (Node node : root.children) {
            postorder(node);
        }
        res.add(root.val);
        
        return res;
    }
}