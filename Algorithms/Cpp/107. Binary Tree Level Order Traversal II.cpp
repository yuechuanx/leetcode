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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> res;
        if(!root) return res;

        queue<TreeNode*> q;
        q.push(root); // 作为初始条件
        while(!q.empty()) {
            vector<int> level;  // 存储二叉树层次的值
            int size = q.size();
            for(int i = 0; i < size; ++i) { // 利用for循环遍历出队列
                TreeNode *node = q.front();
                q.pop();
                level.push_back(node -> val);
                if(node -> left) q.push(node -> left);
                if(node -> right) q.push(node -> right);
            }
            res.insert(res.begin(), level);
        }
        return res;
    }
};
