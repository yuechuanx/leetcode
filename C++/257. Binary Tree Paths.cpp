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
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> res;
        if(root) dfs(root, "", res);
        return res;
    }

    void dfs(TreeNode *root, string out, vector<string> &res) {
        out += to_string(root->val);
        if(!root->left && !root->right) res.push_back(out);
        else {
            if(root->left) dfs(root->left, out + "->", res);
            if(root ->right) dfs(root->right, out + "->", res);
        }
    }
};
