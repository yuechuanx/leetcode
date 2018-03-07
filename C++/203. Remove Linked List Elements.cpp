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
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* preHead = new ListNode(0);
        preHead -> next = head;
        ListNode* cur = preHead;
        while(cur) {
            if(cur -> next && cur -> next -> val == val) cur -> next = cur -> next -> next;
            else
                cur = cur -> next;
        }
        return preHead -> next;
    }
};
