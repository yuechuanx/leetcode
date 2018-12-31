/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0, x, y, sum;

        while (p != null || q != null) {
            x = (p != null) ? p.val : 0;
            y = (q != null) ? q.val : 0;
            sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        if (carry > 0) curr.next = new ListNode(1);

        return dummyHead.next;
    }

}
