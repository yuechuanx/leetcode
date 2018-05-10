/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution
{
  public:
    ListNode *swapPairs(ListNode *head)
    {
        ListNode *dummy = new ListNode(-1), *pre = dummy;
        dummy->next = head;
        while (pre->next && pre->next->next)
        {
            ListNode *t = pre->next->next;
            pre->next->next = t->next; // 让一组中的第一个节点指向下一组的第一个节点
            t->next = pre->next;       // 让一组中第二个节点指向第一个节点
            pre->next = t;             // pre->next指向下一组的前一个节点
            pre = t->next;             // pre 指向前一组的前面两个节点
        }
        return dummy->next;
    }
};