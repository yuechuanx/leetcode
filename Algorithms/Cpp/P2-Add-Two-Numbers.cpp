/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

class Solution {
public:
    // 1563 / 1563 test cases passed.
    // Status: Accepted
    // Runtime: 52 ms
    // Memory Usage: 23.5 MB
    // 时间复杂度:O(max{len(l1), len(l2)})
    // 空间复杂度:O(max{len(l1), len(l2)}) 
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        /* 检查输入参数是否为空 */
        if (l1 == nullptr && l2 == nullptr) return nullptr;
        
        /* 计算当前节点的值 */
        int val = (l1 == nullptr ? 0 : l1->val) + (l2 == nullptr ? 0 : l2->val);
        ListNode *head = new ListNode(val % 10);
        
        /* 计算下一个节点的值 */
        head->next = addTwoNumbers(l1 == nullptr ? nullptr : l1->next,
                                 l2 == nullptr ? nullptr : l2->next);
        if (val >= 10) {  // 如果当前节点有进位，下一节点值 + 1
            head->next = addTwoNumbers(head->next, new ListNode(1));
        }
        
        return head;
    }
};