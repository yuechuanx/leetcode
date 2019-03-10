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
    ListNode* deleteDuplicates(ListNode* head) {
        /* head为null, 或者仅有head节点时候 */
        if(!head || !head->next) return head;
        
        ListNode *start = head;
        while(start && start ->next) {
            if(start -> val == start -> next -> val) {
                ListNode *tmp = start -> next;
                start -> next = start -> next -> next;
                delete tmp;
            } else start = start -> next;
        }
        return head;
    }
};
