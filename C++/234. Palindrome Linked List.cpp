/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

// wrong Solution, find the cause!
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
    bool isPalindrome(ListNode* head) {
        if(head == NULL || head->next == NULL) return true;
        ListNode *preHead = new ListNode(-1);
        preHead -> next = head;
        ListNode *slow = preHead;
        ListNode *fast = preHead;

        stack<int> st;

        while(fast && fast -> next) {
            slow = slow -> next;
            st.push(slow -> val);
            fast = fast -> next -> next;
        }

        if(fast == NULL) st.pop();

        slow = slow -> next;

        while(slow && slow -> val == st.top()) {
            st.pop();
            slow = slow -> next;
        }
        return st.empty();
    }
};
