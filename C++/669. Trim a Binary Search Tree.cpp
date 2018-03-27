/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

 // wrong solution, neet to fix
class Solution {
public:
    TreeNode* trimBST(TreeNode* root, int L, int R) {
        if(!root) return root;

        TreeNode* res;
        if(root->val == L || root->val == R) {
            res = root->val == L ? new TreeNode(L) : new TreeNode(R);
            if(root->val == L ?) {
                root->right = trimBST(root->right, L, R);
            } else {
                root->left = trimBST(root->left, L, R);
            }

        } else if (root->val < L) {
            trimBST(root->right, L, R);
        } else if (root->val > R) {
            trimBST(root->left, L, R);
        }
        return res;
    }
};

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

 // 从原有的root上减去多余的节点，从而满足条件
class Solution {
public:
    TreeNode* trimBST(TreeNode* root, int L, int R) {
        if(!root) return NULL;
        // 首先寻找到L和R的起点，并让root指向其
        while(root->val < L || root->val > R) {
            root = root->val < L ? root->right : root-> left;
        }
        TreeNode* cur = root;
        // 从root开始，减去多余的节点
        while(cur) {
            while(cur->left && cur->left->val < L) {
                cur->left = cur->left->right;
            }
            cur = cur->left;
        }

        cur = root;
        while(cur) {
            while(cur->right && cur->right->val > R) {
                cur->right = cur->right->left;
            }
            cur = cur->right;
        }
        return root;
    }
};
