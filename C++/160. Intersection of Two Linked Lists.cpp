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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        // check the input
        if(!headA || !headB) return NULL;
        // get length of A & B
        int lenA = getLength(headA), lenB = getLength(headB);
        if(lenA > lenB) {
            for(int i = 0; i < lenA - lenB; ++i) {
                headA = headA -> next;
            }
        }
        else {
            for(int i = 0; i < lenB - lenA; ++i) {
                headB = headB -> next;
            }
        }
        while(headA && headB && headA != headB) {
            headA = headA -> next;
            headB = headB -> next;
        }
        return (headA && headB) ? headA : NULL;
    }

    int getLength(ListNode *head) {
        int cnt = 0;
        while (head) {
            ++cnt;
            head = head -> next;
        }
        return cnt;
    }
};
