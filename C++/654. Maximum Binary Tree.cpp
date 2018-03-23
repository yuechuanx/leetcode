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
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        vector<TreeNode*> v;
        for(int num : nums) {
            TreeNode *cur = new TreeNode(num);
            while(!v.empty() && v.back()->val <num) {
                cur->left = v.back();
                v.pop_back();
            }
            if(!v.empty()) {
                v.back()->right = cur;
            }
            v.push_back(cur);
        }
        return v.front();
    }
};
