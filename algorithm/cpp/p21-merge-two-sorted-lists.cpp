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
  ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
      ListNode *res = new ListNode(-1), *cur = res;
      while(l1 && l2) {
          if(l1 -> val > l2 -> val) {
              cur -> next = l2;
              l2 = l2 -> next;
          } else {
              cur -> next = l1;
              l1 = l1 -> next;
          }
          cur = cur -> next;
      }
      cur -> next = l1 ? l1 : l2;
      return res -> next;
  }
};
