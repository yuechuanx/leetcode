/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

 // wrong version, find why it's wrong
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(head == NULL) return NULL;
        ListNode* pre = head;
        ListNode* cur = head -> next;
        while(cur != NULL){
            pre -> next -> next = pre;
            pre = cur;
            cur = cur -> next;
        }
        return pre;
    }
};


class Solution {
public:
    ListNode* reverseList(ListNode* head) {

        ListNode* new_head = new ListNode(0);
        new_head -> next = head;
        ListNode* pre = new_head;
        ListNode* cur = head;

        while (cur && cur -> next) {
            ListNode* temp = pre -> next;
            pre -> next = cur -> next;
            cur -> next = cur -> next -> next;
            pre -> next -> next = temp;
        }
        return new_head -> next;
    }
};
