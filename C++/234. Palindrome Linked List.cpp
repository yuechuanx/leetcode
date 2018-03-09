/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

// wrong Solution, find the cause!
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if(!head) return true;


        ListNode *preHead = new ListNode(-1);
        ListNode *slow = preHead;
        ListNode *fast = preHead;
        stack<int> st;
        while(fast && fast -> next) {
            slow = slow -> next;
            st.push(slow -> val);
            fast = fast -> next -> next;
        }
        slow = slow -> next;
        while(slow) {
            if(slow -> val == st.top()) {
                slow = slow -> next;
                st.pop();
            }
            else return false;

        }
        return st.empty();
    }
};
