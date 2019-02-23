/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        // check the input
        if(!root) return true;

        TreeNode *left, *right;
        queue<TreeNode*> q1, q2;
        q1.push(root -> left);
        q2.push(root -> right);
        while(!q1.empty() && !q2.empty()) {
            left = q1.front();
            q1.pop();
            right = q2.front();
            q2.pop();
            if(NULL == left && NULL == right) {
                continue;
            } else if(NULL == left || NULL == right) {
                return false;
            } else if(left -> val != right -> val) {
                return false;
            }
            q1.push(left -> left);
            q1.push(left -> right);
            // 这里需要注意对称
            q2.push(right -> right);
            q2.push(right -> left);
        }
        return true;
    }
};
