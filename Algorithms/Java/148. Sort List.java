/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Runtime: 6797 ms, faster than 0.97% of Java online submissions for Sort List.
// of course the suck code writed by me, cuz i use bubling sort, time complexity : O(n^2)
class Solution {
    public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;

            // get the length of List
            ListNode p = head;
            int len = 1;
            while (p.next != null) {
                p = p.next;
                len++;
            }

            System.out.println(len);
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            p = dummy;
            ListNode q = head;

            for (int i = 0; i < len; ++i) {
                // initialize the p, q pointer 
                p = dummy;
                q = dummy.next;
                for (int j = 0; j < len && q.next != null; ++j) {
                    if (q.val > q.next.val) {
                        // swap p, p->next
                        p.next = q.next;
                        q.next = q.next.next;
                        p.next.next = q;
                    }
                    p = p.next;
                    q = p.next;
                }
            }

            return dummy.next;
        }
}

// merge sort soultion
